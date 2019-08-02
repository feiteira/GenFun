/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feiteira.libs.genfun.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.feiteira.libs.genfun.Expression;
import org.feiteira.libs.genfun.Operand;
import org.feiteira.libs.genfun.Register;
import org.feiteira.libs.genfun.core.OperandFactory;
import org.feiteira.libs.genfun.core.OperatorFactory;
import org.feiteira.libs.genfun.core.Operator;

/**
 *
 * @author feiteira
 */
public class FunExpression extends Expression {

    private static final Random RANDOM = new Random();
    private static final int SIZE = OperatorFactory.Operators.values().length;
    private static final List<OperatorFactory.Operators> VALUES
            = Collections.unmodifiableList(Arrays.asList(OperatorFactory.Operators.values()));

    private ArrayList<Operand> operands = new ArrayList<>();

    public FunExpression(int nregs) {
        super();

        for (int i = 0; i < nregs; i++) {
            addAtom(Register.createSimpleRegister("r" + i));
        }
        init();
    }

    public ArrayList<Operand> getOperands() {
        return operands;
    }

    public FunExpression(ArrayList<Operand> operands) {
        super();
        this.operands = operands;
        init();
    }

    private void init() {
        set(randomOperator());
        setLeft(randomOperand());
        setRight(randomOperand());
    }

    private Operator randomOperator() {
        return OperatorFactory.createOperation(VALUES.get(RANDOM.nextInt(SIZE)));
    }

    public void addAtom(Operand op) {
        operands.add(op);
    }

    public Operand randomOperand() {
        int type = RANDOM.nextInt(operands.size() + 1);

        if (type < operands.size()) {
            return operands.get(type);
        }

        int subtype = RANDOM.nextInt(7);
        switch (subtype) {
            case 0:
                return OperandFactory.createPi();
            case 1:
                return OperandFactory.createSin(new FunExpression(operands));
            case 2:
                return OperandFactory.createCos(new FunExpression(operands));
            case 3:
                return OperandFactory.createZero();
            case 4:
                return OperandFactory.createRandomMagicNumber();
            case 5:
                return OperandFactory.createSqrt(new FunExpression(operands));
            case 6:
                return OperandFactory.createTan(new FunExpression(operands));
            case 7:
                return new FunExpression(operands);
        }

        return null;
    }
}
