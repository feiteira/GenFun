/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feiteira.libs.genfun.demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.feiteira.libs.genfun.Attribution;

/**
 *
 * @author feiteira
 */
public class FunWindow extends JFrame {

    public static final int ATRIBUTION_COUNT = 10;
    private static final Random RANDOM = new Random();

    static boolean next = false;
    static FunWindow funwi;
    static boolean reset = false;

    final PixelComponent pixie;

    public static void main(String args[]) throws InterruptedException {
        int width = 1920;
        int height = 1080;
        funwi = new FunWindow(width, height);
        boolean waitForNext = false;// to ensure that when you press next, it wont simply move to the next random attrivution set in case the random values make the attribution miss the thresshold to keep running
        final Fun fun = new Fun(width, height, 5);
        System.out.println("I am MAIN!");

        for (int i = 0; i < 10000; i++) {
            Attribution[] funas = fun.makeAttributions(40);
            funwi.updateTextArea(funas);

            long start = System.currentTimeMillis();
            int j;
            for (j = 0; j < 10000000; j++) {
                execAttributions(funas);

//                fun.x.setValue((j%width)/width);
//                fun.y.setValue(((j/width)%height)/height);
                float[] p = fun.nextPixel();
                funwi.pixie.putPixel(p[0], p[1], p[2], p[3], p[4]);
                //funwi.pixie.putPixel((j/1024f)%1024, j %1024, p[2], p[3], p[4]);
                //float[] p = fun.nextLine();
//                funwi.pixie.line(p[0], p[1], p[2], p[3], p[4], p[5], p[6]);

                if (next || (waitForNext == false && j < 13000 && j > 12800 && fun.countChanges() < 2048)) {
                    System.out.println("Break " + i);
                    fun.reset();
                    funwi.clear();
                    next = false;
                    waitForNext = false;
                    break;
                }
                if (reset) {
                    j = 0;
                    fun.reset();
                    funwi.clear();
                    reset = false;
                    waitForNext = true;
                }

                if (j % 200 == 0) {
                    funwi.repaint();
                };
            }
            float dur = (System.currentTimeMillis() - start);
            float speed = (j / dur) * 1000f;
            System.out.println("TIME " + dur);
            System.out.println(j + " SPEED:: " + speed);
            if (j == 1000000) {
                System.out.println("BROKEN!");
                break;
            }

        }

    }

    public void updateTextArea(Attribution atrs[]) {
        String txt = "";
        for (Attribution a : atrs) {
            txt += a.toString() + "\n";
        }
        textArea.setText(txt);
    }

    public static void execAttributions(Attribution[] funas) {
        for (int i = 0; i < funas.length; i++) {
            Attribution funa = funas[i];
            funa.exec();
        }
    }
    private final JTextArea textArea;

    public FunWindow(int width, int height) {
        this.setPreferredSize(new Dimension(600, 600));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.pixie = new PixelComponent(width, height);
        this.add(pixie, BorderLayout.CENTER);

        this.add(new FunPanel(), BorderLayout.NORTH);
        this.textArea = new JTextArea();
        //this.textArea.setSize(100, 100);

        JScrollPane pane = new JScrollPane(textArea);
        //pane.setLayout(new BorderLayout());
        //pane.add();
        pane.setPreferredSize(new Dimension(100, 50));
        this.add(pane, BorderLayout.EAST);
        this.pack();
    }

    public void clear() {
        this.pixie.clear();
    }

    public synchronized void init() {
    }

    public class PixelComponent extends JComponent {

        private Color color;
        final BufferedImage image;
        int width, height;
        private final int[] buffer;

        public PixelComponent(int width, int height) {
            super();
            this.width = width;
            this.height = height;
            int type = BufferedImage.TYPE_INT_RGB;
//            int color = 255; // RGBA value, each component in a byte
            image = new BufferedImage(width, height, type);
            buffer = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
            clear();

        }

        public void clear() {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    //image.setRGB(x, y, new Color(1f, 1f, 1f).getRGB());
                    //putPixel(x,y,0f,x*1f/width,y*1f/height);
                    putPixel(x, y, 0f, 0f, 0f);
                }
            }

        }

        public void line(float x1, float y1, float x2, float y2, float r, float g, float b) {
            Graphics gg = image.getGraphics();
            gg.setColor(new Color(r, g, b));
            gg.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }

        public void putPixel(float x, float y, float r, float g, float b) {
//            image.setRGB((int) (x), (int) (y), new Color(r, g, b).getRGB());
            int red = (int) (256 * r);
            int green = (int) (256 * g);
            int blue = (int) (256 * b);
            buffer[((int) y) * width + (int) x] = red << 16 | green << 8 | blue;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // System.out.println("aa");
            // g.setColor(color);
            // g.fillRect(0, 0, 25, 25);
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }

    }
}
