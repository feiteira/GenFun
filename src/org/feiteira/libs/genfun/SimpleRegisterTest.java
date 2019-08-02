package org.feiteira.libs.genfun;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.feiteira.libs.genfun.core.OperatorFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author feiteira
 */
public class SimpleRegisterTest {
    private Register y;
    private Register x;
    
    public SimpleRegisterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testSimple() {
          x = Register.createSimpleRegister("x");         
          y = Register.createSimpleRegister("y");

         
         assertEquals(0f, x.eval(),0f);
         assertEquals(0f, y.eval(),0f);                                    

         x.setValue(5f);
         y.setValue(7f);

         assertEquals(5f, x.eval(),0f);
         assertEquals(7f, y.eval(),0f);                                    
     }
     
     @Test
     public void testOperation(){
         testSimple();
         Expression e = new Expression(OperatorFactory.createAddition(), x, y);
         System.out.println("> " + e.toString());
         assertEquals(12f, e.eval(),0f);

     }
}
