package com.example.calculatorapp.domains.calculator.internals.adapters;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.INFINITY_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.NOT_A_NUMBER_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.NOT_VALID_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.EXPRESSION_TO_BE_EVALUATED;

import static org.junit.Assert.assertEquals;

import com.example.calculatorapp.domains.calculator.Characters;
import com.example.calculatorapp.domains.calculator.internals.errors.NotValidExpressionException;

import org.junit.Test;

public class ExpressionEvaluatorTest {
    @Test
    public void testIfMethodGetEvaluatedCalculationExpressionReturnsEvaluatedExpression() throws Exception {
        String evaluatedExpression = ExpressionEvaluator.getEvaluatedCalculationExpression(
                EXPRESSION_TO_BE_EVALUATED
        );

        assertEquals(
                EVALUATED_SIMPLE_CALCULATION_EXPRESSION,
                evaluatedExpression
        );
    }

    @Test
    public void testIfMethodGetEvaluatedCalculationExpressionReturnsNotValidExpressionIfExpressionIsNotValid() {
        try {
            ExpressionEvaluator.getEvaluatedCalculationExpression(
                    NOT_VALID_CALCULATION_EXPRESSION
            );
        } catch (Exception exception) {
            assert (exception instanceof NotValidExpressionException);
        }

        try {
            ExpressionEvaluator.getEvaluatedCalculationExpression(
                    INFINITY_EXPRESSION
            );
        } catch (Exception exception) {
            assert (exception instanceof NotValidExpressionException);
        }

        try {
            ExpressionEvaluator.getEvaluatedCalculationExpression(
                    NOT_A_NUMBER_EXPRESSION
            );
        } catch (Exception exception) {
            assert (exception instanceof NotValidExpressionException);
        }
    }
}