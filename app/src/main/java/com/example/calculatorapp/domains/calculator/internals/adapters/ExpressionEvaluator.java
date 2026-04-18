package com.example.calculatorapp.domains.calculator.internals.adapters;

import static com.example.calculatorapp.domains.calculator.internals.checkers.CalculatorChecker.INSTANCE;

import com.example.calculatorapp.domains.calculator.internals.errors.NotValidExpressionException;

import net.objecthunter.exp4j.ExpressionBuilder;

public class ExpressionEvaluator {
    public static String getEvaluatedCalculationExpression(String calculationExpression) throws NotValidExpressionException {
        try {
            double evaluatedCalculationExpression = new ExpressionBuilder(calculationExpression)
                    .build()
                    .evaluate();

            if (INSTANCE.isCalculationExpressionRationalNumber(evaluatedCalculationExpression)) {
                return Double.toString(evaluatedCalculationExpression);
            } else {
                return Integer.toString((int) evaluatedCalculationExpression);
            }
        } catch (Exception exception) {
            throw new NotValidExpressionException();
        }
    }
}
