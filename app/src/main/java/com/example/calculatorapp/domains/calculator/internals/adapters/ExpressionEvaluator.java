package com.example.calculatorapp.domains.calculator.internals.adapters;

import static com.example.calculatorapp.constants.CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE;
import static com.example.calculatorapp.domains.calculator.internals.checkers.CalculatorChecker.INSTANCE;
import net.objecthunter.exp4j.ExpressionBuilder;

public class ExpressionEvaluator {
    public static String getEvaluatedCalculationExpression(String calculationExpression) {
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
            return NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE;
        }
    }
}
