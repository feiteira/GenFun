/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.feiteira.libs.genfun.Expression;
import org.feiteira.libs.genfun.demo.FunExpression;
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
public class TestFunExpression {
    
    public TestFunExpression() {
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
     public void createFunExpressions() {
         int n_expressions = 100;
         for(; n_expressions>0;n_expressions--)
         {
             Expression exp = new FunExpression(5);

             System.out.println(exp.toString());
         }
         assertEquals(0, n_expressions);
         
     }
}
