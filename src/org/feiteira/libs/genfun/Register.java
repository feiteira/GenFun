/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feiteira.libs.genfun;

/**
 *
 * @author feiteira
 */
public abstract class Register implements Operand {

    private static int register_counter = 0;

    public static Register createSimpleRegister(final String name) {
        Register ret = new Register() {
            private float value = 0f;

            @Override
            public float eval() {
                return value;
            }

            @Override
            public void setValue(float value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return name;
            }

        };
        register_counter++;

        return ret;
    }

    public abstract float eval();

    public abstract void setValue(float value);

    public abstract String toString();
}
