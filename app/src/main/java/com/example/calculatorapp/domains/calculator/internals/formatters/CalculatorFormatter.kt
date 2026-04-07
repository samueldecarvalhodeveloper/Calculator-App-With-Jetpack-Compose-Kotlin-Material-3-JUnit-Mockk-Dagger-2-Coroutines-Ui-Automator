package com.example.calculatorapp.domains.calculator.internals.formatters

class CalculatorFormatter {
    companion object {
        fun getCalculationExpressionWithoutLastCharacter(calculationExpression: String): String {
            return calculationExpression.substring(
                0,
                calculationExpression.length - 1
            )
        }
    }
}