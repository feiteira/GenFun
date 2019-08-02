/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feiteira.libs.genfun.demo;

import java.util.ArrayList;
import java.util.Random;
import org.feiteira.libs.genfun.Attribution;
import org.feiteira.libs.genfun.Operand;
import org.feiteira.libs.genfun.Register;

/**
 *
 * @author feiteira
 */
public class Fun {

    private static final Random RANDOM = new Random();

    ArrayList<Operand> registers;
    private int width;
    private int height;
    private Register x, y, r, g, b;//, x2, y2;

    boolean[][] changed;//a list of all the pixels that changed

    public Fun() {
        this(1024, 768, 0);
    }

    public Fun(int width, int height, int n_gp_regs) {
        registers = new ArrayList<>();

        x = Register.createSimpleRegister("x");
        y = Register.createSimpleRegister("y");
        //x2 = Register.createSimpleRegister("x2");
        //y2 = Register.createSimpleRegister("y2");

        r = Register.createSimpleRegister("r");
        g = Register.createSimpleRegister("g");
        b = Register.createSimpleRegister("b");

        x.setValue((float) Math.PI);
        y.setValue(RANDOM.nextFloat());
        //x2.setValue((float) Math.PI);
        //y2.setValue(RANDOM.nextFloat());

        r.setValue(RANDOM.nextFloat());
        g.setValue(RANDOM.nextFloat());
        b.setValue(RANDOM.nextFloat());
        registers.add(x);
        registers.add(y);
        //registers.add(x2);
        //registers.add(y2);

        registers.add(r);
        registers.add(g);
        registers.add(b);

        for (int i = 0; i < n_gp_regs; i++) {
            registers.add(Register.createSimpleRegister("r" + i));
        }

        this.width = width;
        this.height = height;
        
        changed = new boolean[width][height];
    }

    public void resetChangeMap() {
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                changed[x][y] = false;
            }
        }
    }

    public int countChanges() {
        int ret = 0;
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                if (changed[x][y]) {
                    ret++;
                }
            }
        }
        return ret;
    }

    public Attribution[] makeAttributions(int n) {
        Attribution funas[] = new Attribution[n];
        for (int i = 0; i < funas.length; i++) {
            Attribution funa = createFunAttribution();
    //        System.out.println("\t" + funa.toString());
            //funa.exec();
            //   prettyPrint();
            funas[i] = funa;
        }
        return funas;
    }

    public void initRegisters() {
        registers.forEach((reg) -> {
            if (reg instanceof Register) {
                ((Register) reg).setValue(RANDOM.nextFloat());
            }
        });
    }

    public float[] nextPixel() {
        float[] ret = new float[5];
        ret[0] = Math.abs(x.eval() * this.width) % this.width;
        ret[1] = Math.abs(y.eval() * this.height) % this.height;
        ret[2] = Math.abs(r.eval()) % 1f;
        ret[3] = Math.abs(g.eval()) % 1f;
        ret[4] = Math.abs(b.eval()) % 1f;

        changed[(int) ret[0]][(int) ret[1]] = true;
        return ret;

    }
/*
    public float[] nextLine() {
        float[] ret = new float[7];
        ret[0] = Math.abs(x.eval() * this.width) % this.width;
        ret[1] = Math.abs(y.eval() * this.height) % this.height;
        ret[4] = Math.abs(r.eval()) % 1f;
        ret[5] = Math.abs(g.eval()) % 1f;
        ret[6] = Math.abs(b.eval()) % 1f;

        //x2,y2
        ret[2] = Math.abs(x2.eval() * this.width) % this.width;
        ret[3] = Math.abs(y2.eval() * this.height) % this.height;

        changed[(int) ret[0]][(int) ret[1]] = true;
        changed[(int) ret[2]][(int) ret[3]] = true;

        return ret;
    }
*/
    public void reset() {
        initRegisters();
        resetChangeMap();
    }

    public void prettyPrint() {
        for (int i = 0; i < registers.size(); i++) {
            Operand r = registers.get(i);
            System.out.println(r.toString() + " = " + r.eval());
        }
    }

    public void addRegister(Register r) {
        registers.add(r);
    }

    public Attribution createFunAttribution() {
        Register reg = (Register) registers.get(RANDOM.nextInt(registers.size()));

        return new Attribution(reg, new FunExpression(registers));
    }

}
