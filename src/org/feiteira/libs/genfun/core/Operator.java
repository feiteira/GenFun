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
public abstract class Operator {
    public abstract float exec(Operand e1, Operand e2);
}
