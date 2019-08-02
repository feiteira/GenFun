/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feiteira.libs.genfun.core;

import org.feiteira.libs.genfun.Expression;
import org.feiteira.libs.genfun.Operand;

/**
 *
 * @author feiteira
 */
public class OperandFactory {

    public static Operand createRandomMagicNumber() {
        return new Operand() {
            float f = (float) Math.random();

            @Override
            public float eval() {
                return (float) f;
            }

            @Override
            public String toString() {
                return "" + f;
            }

        };
    }

    public static Operand createZero() {
        return new Operand() {
            @Override
            public float eval() {
                return 0f;
            }

            @Override
            public String toString() {
                return "0";
            }

        };
    }

    public static Operand createPi() {
        return new Operand() {
            @Override
            public float eval() {
                return (float) Math.PI;
            }

            @Override
            public String toString() {
                return "PI";
            }

        };
    }

    public static Operand createSin(Expression e) {
        return new Operand() {
            @Override
            public float eval() {
                return (float) Math.sin(e.eval());
            }

            @Override
            public String toString() {
                return "sin(" + e.toString() + ")";
            }

        };
    }

    public static Operand createCos(Expression e) {
        return new Operand() {
            @Override
            public float eval() {
                return (float) Math.cos(e.eval());
            }

            @Override
            public String toString() {
                return "cos(" + e.toString() + ")";
            }

        };
    }

    public static Operand createTan(Expression e) {
        return new Operand() {
            @Override
            public float eval() {
                return (float) Math.tan(e.eval());
            }

            @Override
            public String toString() {
                return "tan(" + e.toString() + ")";
            }

        };
    }

    public static Operand createSqrt(Expression e) {
        return new Operand() {
            @Override
            public float eval() {
                return (float) Math.sqrt(e.eval());
            }

            @Override
            public String toString() {
                return "sqrt(" + e.toString() + ")";
            }

        };
    }

}
