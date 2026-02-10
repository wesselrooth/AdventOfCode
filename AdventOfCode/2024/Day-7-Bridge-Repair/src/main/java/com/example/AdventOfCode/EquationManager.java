package com.example.AdventOfCode;

import javax.management.OperationsException;

public class EquationManager {

    public EquationManager(){

    }

    public long calculationResult(long left, long right, String operator) throws OperatorException {

        if (operator.equals("+")){
            return left + right;
        }else if (operator.equals("*")){
            return left * right;
        }else {
            throw new OperatorException("Unsupported operator");
        }
    }

}
