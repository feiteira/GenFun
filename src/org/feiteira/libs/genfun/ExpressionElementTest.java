/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feiteira.libs.genfun;

import org.feiteira.libs.genfun.core.OperatorFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author feiteira
 */
public class ExpressionElementTest {

    private Element e1;
    private Element e2;
    private Expression ee;

    public ExpressionElementTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.out.println("Setting up...");
    }

    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testBasicAddition() {
        System.out.println("Basic Addition");

        Expression e = new Expression(OperatorFactory.createAddition(), new Element(10f), new Element(20f));

        float result = e.eval();
        System.out.println("Res:" + result);

        assertEquals(30f, result, 0);

        System.out.println(e);
        assertEquals("10.0 + 20.0", e.toString());
    }

    @org.junit.Test
    public void testBasicMultiplication() {
        System.out.println("Basic Multiplication");

        Expression e = new Expression(OperatorFactory.createMultiplication(), new Element(10f), new Element(20f));

        float result = e.eval();
        System.out.println("Res:" + result);
        assertEquals(200f, result, 0);

        System.out.println(e);
        assertEquals("10.0 * 20.0", e.toString());
    }

    @org.junit.Test
    public void testBasicWitgLeftRightBuildMethod() {
        Expression e = new Expression();

        e.set(OperatorFactory.createMultiplication()).setLeft(new Element(10f)).setRight(new Element(2f));

        float result = e.eval();
        System.out.println("Res:" + result);
        assertEquals(20f, result, 0);

        System.out.println(e);
        assertEquals("10.0 * 2.0", e.toString());
    }

    @org.junit.Test
    public void testInnerExpression() {
        Expression e = new Expression();

        e.set(OperatorFactory.createMultiplication()).setLeft(new Element(10f))
                .setRight(new Expression(OperatorFactory.createDivision(), 7f, 4f));

        float result = e.eval();
        System.out.println("Res:" + result);
        assertEquals(17.5, result, 0);

        System.out.println(e);
        assertEquals("10.0 * (7.0 / 4.0)", e.toString());
    }

}
