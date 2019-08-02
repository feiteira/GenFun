/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feiteira.libs.genfun;

import java.util.ArrayList;

/**
 *
 * @author feiteira
 */
public class Attribution {

    Register target;
    Expression expression;

    public Attribution() {
    }

    public Attribution(Register target, Expression expression) {
        this.target = target;
        this.expression = expression;
    }

    
    public void exec(){
        this.target.setValue(this.expression.eval());
    }
    
    public Register getTarget() {
        return target;
    }

    public void setTarget(Register target) {
        this.target = target;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
    
    @Override
    public String toString(){
    return target.toString() + " = " + expression.toString();}
}
