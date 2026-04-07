package com.example.calculatorapp.domains.calculator

import com.example.calculatorapp.constants.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.constants.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.constants.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class CalculationExpressionTest {
    private lateinit var calculationExpression: CalculationExpression

    @Before
    fun beforeEach() {
        calculationExpression = CalculationExpression("")
    }

    @Test
    fun testIfMethodGetCalculationExpressionReturnCurrentCalculationExpression() {
        val currentCalculationExpression =
            calculationExpression.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodAddCharacterToCalculatorExpressionAddChoseCharacterToCalculationExpression() {
        calculationExpression.addCharacterToCalculationExpression(CalculatorCharacters.ONE)

        val currentCalculationExpression: String =
            calculationExpression.getCalculationExpression()

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression)
    }

    @Test
    fun testIfMethodRemoveLastCharacterFromCalculationExpressionRemovesLastCharacterFromExpression() {
        calculationExpression = CalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        calculationExpression.removeLastCharacterFromCalculationExpression()

        val currentCalculationExpression: String =
            calculationExpression.getCalculationExpression()

        assertEquals(
            SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER,
            currentCalculationExpression
        )
    }

    @Test
    fun testIfMethodTurnCalculationExpressionEmptyMakesTheCalculationExpressionIntoEmptyString() {
        calculationExpression = CalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        val currentCalculationExpression: String =
            calculationExpression.getCalculationExpression()

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression)

        calculationExpression.turnCalculationExpressionEmpty()

        val updatedCalculationExpression: String =
            calculationExpression.getCalculationExpression()

        assertEquals("", updatedCalculationExpression)
    }

    @Test
    fun testIfMethodEvaluateCalculationExpressionTurnsTheCalculationExpressionIntoEvaluatedValue() {
        calculationExpression = CalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        calculationExpression.evaluateCalculationExpression()

        val currentCalculationExpression: String =
            calculationExpression.getCalculationExpression()

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression)
    }
}
