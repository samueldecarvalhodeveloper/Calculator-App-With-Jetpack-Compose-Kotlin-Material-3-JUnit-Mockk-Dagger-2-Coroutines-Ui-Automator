package com.example.calculatorapp.domains.calculator.internals.checkers

import com.example.calculatorapp.constants.domains.CalculatorConstants
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NUMBER_WITHOUT_REST
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NUMBER_WITH_REST
import com.example.calculatorapp.domains.calculator.internals.checkers.CalculatorChecker.isCalculationExpressionEmpty
import com.example.calculatorapp.domains.calculator.internals.checkers.CalculatorChecker.isCalculationExpressionNotValidExpressionExceptionMessage
import com.example.calculatorapp.domains.calculator.internals.checkers.CalculatorChecker.isCalculationExpressionRationalNumber
import org.junit.Assert
import org.junit.Test

class CalculatorCheckerTest {
    @Test
    fun testIfMethodIsCalculationExpressionARationalNumberReturnsTrueIfNumberIsAFloatingNumber() {
        val rationalNumber: Boolean = isCalculationExpressionRationalNumber(NUMBER_WITH_REST)
        val notRationalNumber: Boolean = isCalculationExpressionRationalNumber(NUMBER_WITHOUT_REST)

        Assert.assertTrue(rationalNumber)
        Assert.assertFalse(notRationalNumber)
    }

    @Test
    fun testIfMethodIsCalculationExpressionEmptyReturnsTrueIfCalculationExpressionIsEmpty() {
        val emptyExpression: Boolean = isCalculationExpressionEmpty("")
        val notEmptyExpression: Boolean =
            isCalculationExpressionEmpty(CalculatorConstants.EXPRESSION_TO_BE_EVALUATED)

        Assert.assertTrue(emptyExpression)
        Assert.assertFalse(notEmptyExpression)
    }

    @Test
    fun testIfMethodIsCalculationExpressionNotValidExpressionExceptionMessageReturnsTrueIfCalculationExpressionIsNotValidExpressionMessage() {
        val calculationExpressionIsNotValidExpressionMessage: Boolean =
            isCalculationExpressionNotValidExpressionExceptionMessage(
                CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
            )
        val notValidExpressionMessage: Boolean =
            isCalculationExpressionNotValidExpressionExceptionMessage(CalculatorConstants.EXPRESSION_TO_BE_EVALUATED)

        Assert.assertTrue(calculationExpressionIsNotValidExpressionMessage)
        Assert.assertFalse(notValidExpressionMessage)
    }
}