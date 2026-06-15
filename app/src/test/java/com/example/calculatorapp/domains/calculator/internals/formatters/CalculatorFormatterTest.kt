package com.example.calculatorapp.domains.calculator.internals.formatters

import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EXPRESSION_TO_BE_EVALUATED
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EXPRESSION_TO_BE_EVALUATED_WITHOUT_LAST_CHARACTER
import com.example.calculatorapp.domains.calculator.internals.formatters.CalculatorFormatter.Companion.getCalculationExpressionWithoutLastCharacter
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorFormatterTest {
    @Test
    fun testIfMethodGetCalculationExpressionWithoutLastCharacterReturnExpressionWithoutLastCharacter() {
        val calculationExpressionWithoutLastCharacter: String =
            getCalculationExpressionWithoutLastCharacter(EXPRESSION_TO_BE_EVALUATED)

        assertEquals(
            EXPRESSION_TO_BE_EVALUATED_WITHOUT_LAST_CHARACTER,
            calculationExpressionWithoutLastCharacter
        )
    }
}
