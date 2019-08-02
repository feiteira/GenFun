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
public class Expression implements Operand {

    private ExpressionType type;


    /*
     An expression is:
     <operand> [<operator> <operand>]*
     */
    private Operator operator;

    private Operand operand;
    private Expression left, right;

    public Expression() {
        type = ExpressionType.Atomic;
        set(new Element(0f));
    }

    public Expression(Operand operand) {
        set(operand);
    }

    public Expression(Operator operator) {
        set(operator);
    }

    public Expression(Operator operator, float left, float right) {
        this(operator);
        this.left = new Expression(new Element(left));
        this.right = new Expression(new Element(right));
    }

    public Expression(Operator operator, Operand left, Operand right) {
        this(operator);
        this.left = new Expression(left);
        this.right = new Expression(right);
    }

    public Expression set(Operator operator) {
        this.operator = operator;
        this.type = ExpressionType.Complex;
        return this;
    }

    private Expression set(Operand operand) {
        this.operand = operand;
        this.type = ExpressionType.Atomic;
        return this;
    }

    public ExpressionType getType() {
        return type;
    }

    public Operator getOperator() {
        return operator;
    }

    public Operand getOperand() {
        return operand;
    }

    public Expression left() {
        return left;
    }

    public Expression right() {
        return right;
    }

    public Expression setRight(Expression right) {
        this.right = right;
        return this;
    }

    public Expression setLeft(Expression left) {
        this.left = left;
        return this;
    }

    public Expression setRight(Operand right) {
        if (right instanceof Expression) {
            this.right = (Expression) right;
        } else {
            this.right = new Expression(right);
        }
        return this;
    }

    public Expression setLeft(Operand left) {
        if (left instanceof Expression) {
            this.left = (Expression) left;
        } else {
            this.left = new Expression(left);
        }
        return this;
    }

    @Override
    public String toString() {
        switch (this.type) {
            case Atomic:
                return operand.toString();
            case Complex:
                return left.toStringSmartBrackets() + " "
                        + operator.toString() + " "
                        + right.toStringSmartBrackets();
        }
        return null;
    }

    private String toStringSmartBrackets() {
        if (this.type == ExpressionType.Atomic) {
            return this.toString();
        }
        return "(" + this.toString() + ")";
    }

    public float eval() {
        switch (this.type) {
            case Atomic:
                return operand.eval();
            case Complex:
                return operator.exec(left, right);
        }
        return 0f;
    }

    public enum ExpressionType {

        Atomic, Complex
    }

    public class InvalidExpressionException extends Exception {

        public InvalidExpressionException() {
            super();
        }
    }
}
