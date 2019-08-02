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
public abstract class Processor {
    
    public abstract int getRegsiterCount();
    public abstract Register getRegister(int register);
    
    public float getRegisterValue(int register){
        return getRegister(register).eval();
    }
    public abstract float setRegisterValue(int register, float value);
}
