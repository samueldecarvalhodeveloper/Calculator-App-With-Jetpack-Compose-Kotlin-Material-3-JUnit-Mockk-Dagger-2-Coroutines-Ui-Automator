package com.example.calculatorapp.domains.calculator

import com.example.calculatorapp.constants.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.constants.CalculatorConstants.Companion.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import com.example.calculatorapp.constants.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class CalculationExpressionDecoratorTest {
    private lateinit var calculationExpression: CalculationExpressionDecorator

    @Before
    fun beforeEach() {
        calculationExpression = CalculationExpressionDecorator("")
    }

    @Test
    fun testIfMethodAddCharacterToCalculationExpressionTurnsCalculationToEmptyWhenIsNotValidExpressionExceptionMessage() {
        calculationExpression = CalculationExpressionDecorator(
            NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
        )

        calculationExpression.addCharacterToCalculationExpression(
            CalculatorCharacters.ONE
        )

        val currentCalculationExpression =
            calculationExpression.getCalculationExpression()

        assertEquals("", currentCalculationExpression)

        calculationExpression.addCharacterToCalculationExpression(
            CalculatorCharacters.ONE
        )

        val updateCalculationExpression = calculationExpression.getCalculationExpression()

        assertEquals(CalculatorCharacters.ONE.value, updateCalculationExpression)
    }

    @Test
    fun testIfMethodRemoveLastCharacterFromCalculationExpressionTurnsCalculationEmptyIfExpressionIsNotValidExpressionExceptionMessage() {
        calculationExpression = CalculationExpressionDecorator(
            NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
        )

        calculationExpression.removeLastCharacterFromCalculationExpression()

        val currentCalculationExpression =
            calculationExpression.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodTurnCalculationExpressionEmptyCallsTheSuperTypeMethodAndTurnsExpressionEmpty() {
        calculationExpression = CalculationExpressionDecorator(
            SIMPLE_CALCULATION_EXPRESSION
        )

        calculationExpression.turnCalculationExpressionEmpty()

        val currentCalculationExpression =
            calculationExpression.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodEvaluateCalculationExpressionDoNotDoNothingIfExpressionIsNotValidExpressionExceptionMessage() {
        calculationExpression = CalculationExpressionDecorator(
            NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
        )

        calculationExpression.evaluateCalculationExpression()

        val currentCalculationExpression =
            calculationExpression.getCalculationExpression()

        assertEquals(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, currentCalculationExpression)

        calculationExpression = CalculationExpressionDecorator(
            SIMPLE_CALCULATION_EXPRESSION
        )

        calculationExpression.evaluateCalculationExpression()

        val syntaxCorrectCalculationExpression =
            calculationExpression.getCalculationExpression()

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, syntaxCorrectCalculationExpression)
    }
}
