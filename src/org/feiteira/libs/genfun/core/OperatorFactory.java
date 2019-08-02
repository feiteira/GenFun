/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feiteira.libs.genfun.core;

import org.feiteira.libs.genfun.Operand;

/**
 *
 * @author feiteira
 */
public class OperatorFactory {

    public static enum Operators {
        Addition, Subtraction, Multiplication, Division//, Exponential
    };

    public static Operator createOperation(Operators op){
        switch(op){
            case Addition: return createAddition();
            case Subtraction: return createSubtraction();
            case Multiplication: return createMultiplication();
            case Division: return createDivision();
    //        case Exponential: return createExponent();
        }
        return null;
    }
    
    public static Operator createAddition() {
        return new Operator() {
            @Override
            public float exec(Operand e1, Operand e2) {
                return e1.eval() + e2.eval();
            }

            @Override
            public String toString() {
                return "+";
            }

        };
    }

    public static Operator createSubtraction() {
        return new Operator() {
            @Override
            public float exec(Operand e1, Operand e2) {
                return e1.eval() - e2.eval();
            }

            @Override
            public String toString() {
                return "-";
            }

        };
    }

    public static Operator createMultiplication() {
        return new Operator() {
            @Override
            public float exec(Operand e1, Operand e2) {
                return e1.eval() * e2.eval();
            }

            @Override
            public String toString() {
                return "*";
            }

        };
    }

    public static Operator createDivision() {
        return new Operator() {
            @Override
            public float exec(Operand e1, Operand e2) {
                return e1.eval() / e2.eval();
            }

            @Override
            public String toString() {
                return "/";
            }

        };
    }

    public static Operator createExponent() {
        return new Operator() {
            @Override
            public float exec(Operand e1, Operand e2) {
                return (float) Math.pow(e1.eval(), e2.eval());
            }

            @Override
            public String toString() {
                return "^";
            }

        };
    }

}
