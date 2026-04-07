package com.example.calculatorapp.domains.calculator.internals.checkers

import com.example.calculatorapp.constants.CalculatorConstants

object CalculatorChecker {
    fun isCalculationExpressionRationalNumber(evaluatedCalculationExpression: Double): Boolean {
        return evaluatedCalculationExpression != evaluatedCalculationExpression.toInt().toDouble()
    }

    fun isCalculationExpressionEmpty(calculationExpression: String): Boolean {
        return calculationExpression == ""
    }

    fun isCalculationExpressionNotValidExpressionExceptionMessage(calculationExpression: String): Boolean {
        return calculationExpression == CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
    }
}