/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feiteira.libs.genfun.demo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author feiteira
 */
public class FunPanel extends JPanel {

    public FunPanel() {
        super();
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addNext();
        addSave();
        addReset();
    }

    private void addNext() {
        JButton next = new JButton("Next");
        next.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                FunWindow.next = true;
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.add(next);
    }

    private void addSave() {
        JButton next = new JButton("Save");
        next.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                File outputfile = new File(System.currentTimeMillis() + ".png");
                try {
                    ImageIO.write(FunWindow.funwi.pixie.image, "png", outputfile);
                } catch (IOException ex) {
                    Logger.getLogger(FunPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.add(next);

    }

    private void addReset() {
        JButton next = new JButton("Reset");
        next.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                FunWindow.reset = true;

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.add(next);

    }

        private void addFill() {
        JButton next = new JButton("Fill");
        next.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                FunWindow.next = true;
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.add(next);
    }

}
