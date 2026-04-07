package com.example.calculatorapp.domains.calculator.internals.adapters;

import static com.example.calculatorapp.constants.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.constants.CalculatorConstants.NOT_VALID_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.constants.CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE;
import static com.example.calculatorapp.constants.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExpressionEvaluatorTest {
    @Test
    public void testIfMethodGetEvaluatedCalculationExpressionReturnsEvaluatedExpression() {
        String evaluatedExpression = ExpressionEvaluator.getEvaluatedCalculationExpression(
            SIMPLE_CALCULATION_EXPRESSION
        );

        assertEquals(
            EVALUATED_SIMPLE_CALCULATION_EXPRESSION,
            evaluatedExpression
        );
    }

    @Test
    public void testIfMethodGetEvaluatedCalculationExpressionReturnsNotValidExpressionIfExpressionIsNotValid() {
        String evaluatedExpression = ExpressionEvaluator.getEvaluatedCalculationExpression(
            NOT_VALID_CALCULATION_EXPRESSION
        );

        assertEquals(
            NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE,
            evaluatedExpression
        );
    }
}