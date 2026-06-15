package com.example.calculatorapp.domains.calculator

import com.example.calculatorapp.domains.calculator.internals.errors.NotValidExpressionException
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private lateinit var calculator: Calculator

    @Before
    fun beforeEach() {
        calculator = Calculator("")
    }

    @Test
    fun testIfMethodAddCharacterAddsCharacterToExpression() {
        calculator.addCharacter(Characters.ONE)

        assertEquals(Characters.ONE.value, calculator.expression)
    }

    @Test
    fun testIfMethodBackspaceRemovesLastCharacterFromExpression() {
        calculator = Calculator(Characters.ONE.value + Characters.ONE.value)

        calculator.backspace()

        assertEquals(Characters.ONE.value, calculator.expression)
    }

    @Test
    fun testIfMethodCleanRemovesAllCharactersFromExpression() {
        calculator = Calculator(Characters.ONE.value + Characters.ONE.value)

        calculator.clean()

        assertEquals("", calculator.expression)
    }

    @Test
    fun testIfMethodEvaluateEvaluatesExpression() {
        calculator = Calculator(
            Characters.ONE.value +
                    Characters.ADDITION.value +
                    Characters.ONE.value
        )

        calculator.evaluate()

        assertEquals(Characters.TWO.value, calculator.expression)
    }

    @Test
    fun testIfMethodEvaluateTurnsExpressionToEmptyAndRethrowsRisenError() {
        calculator = Calculator(Characters.ADDITION.value + Characters.ADDITION.value)

        try {
            calculator.evaluate()
        } catch (exception: Exception) {
            assertEquals("", calculator.expression)

            assert(exception is NotValidExpressionException)
        }
    }
}
