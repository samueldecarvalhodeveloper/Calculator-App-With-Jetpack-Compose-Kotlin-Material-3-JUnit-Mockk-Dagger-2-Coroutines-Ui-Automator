package com.example.calculatorapp.domains.calculator

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private lateinit var calculator: Calculator
    private lateinit var calculationExpression: CalculationExpression

    @Before
    fun beforeEach() {
        calculationExpression =
            CalculationExpressionDecorator("")
        calculator = Calculator(calculationExpression)
    }

    @Test
    fun testIfMethodGetCalculationExpressionReturnsCalculationExpression() {
        val currentCalculationExpression: String =
            calculationExpression.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodAddCharacterAddsCharacterToCalculationExpression() {
        calculator.addCharacter(CalculatorCharacters.ONE)

        val currentCalculationExpression: String =
            calculationExpression.getCalculationExpression()

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression)
    }

    @Test
    fun testIfMethodBackspaceRemovesLastCharacterFromCalculationExpression() {
        calculationExpression.addCharacterToCalculationExpression(CalculatorCharacters.ONE)
        calculationExpression.addCharacterToCalculationExpression(CalculatorCharacters.ONE)

        calculator.backspace()

        val currentCalculationExpression: String =
            calculationExpression.getCalculationExpression()

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression)
    }

    @Test
    fun testIfMethodCleanRemovesAllCharactersFromCalculationExpression() {
        calculationExpression.addCharacterToCalculationExpression(CalculatorCharacters.ONE)

        calculator.clean()

        val currentCalculationExpression: String =
            calculationExpression.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodEvaluateEvaluatesCalculationExpression() {
        calculationExpression.addCharacterToCalculationExpression(CalculatorCharacters.ONE)
        calculationExpression.addCharacterToCalculationExpression(CalculatorCharacters.ADDITION)
        calculationExpression.addCharacterToCalculationExpression(CalculatorCharacters.ONE)

        calculator.evaluate()

        val currentCalculationExpression: String =
            calculationExpression.getCalculationExpression()

        assertEquals(CalculatorCharacters.TWO.value, currentCalculationExpression)
    }
}
