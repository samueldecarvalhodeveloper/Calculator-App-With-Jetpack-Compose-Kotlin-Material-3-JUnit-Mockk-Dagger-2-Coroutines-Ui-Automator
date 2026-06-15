package com.example.calculatorapp.domains.calculator.internals.formatters

class CalculatorFormatter {
    companion object {
        fun getCalculationExpressionWithoutLastCharacter(calculationExpression: String): String {
            return calculationExpression.dropLast(1)
        }
    }
}