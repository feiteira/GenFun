/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feiteira.libs.genfun;

import org.feiteira.libs.genfun.core.Operator;

/**
 *
 * @author feiteira
 */
public class Element implements Operand {

    public enum ElementType {

        EXPRESSION, REGISTER, VALUE
    }
    private ElementType type;
    private Object body;

    public Element(float value) {
        this.body = (Float) value;
        this.type = ElementType.VALUE;
    }

    public Element(Register reg) {
        this.type = ElementType.REGISTER;
        this.body = reg;
    }

    public Element(Expression exp) {
        this.type = ElementType.EXPRESSION;
        this.body = exp;
    }

    public Element(Operator op, float value) {
        this.body = (Float) value;
        this.type = ElementType.VALUE;
    }

    public Element(Operator op, Register reg) {
        this.type = ElementType.REGISTER;
        this.body = reg;
    }

    public Element(Operator op, Expression exp) {
        this.type = ElementType.EXPRESSION;
        this.body = exp;
    }


    @Override
    public String toString() {
        String ret = "";

        switch (this.type) {
            case VALUE:
                ret += "" + ((float) body);
                break;
            case REGISTER:
                ret += ((Register) body).toString();
                break;
            case EXPRESSION:
                ret += ((Expression) body).toString();
                break;
        }
        if (ret == "") {
            return null;
        }
        return ret;
    }

    public float eval() {
        switch (this.type) {
            case VALUE:
                return (float) body;
            case REGISTER:
                return ((Register) body).eval();
            case EXPRESSION:
                return ((Expression) body).eval();
        }
        throw new NullPointerException();
    }
}
