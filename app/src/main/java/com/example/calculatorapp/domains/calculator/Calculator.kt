package com.example.calculatorapp.domains.calculator

import com.example.calculatorapp.domains.calculator.internals.adapters.ExpressionEvaluator
import com.example.calculatorapp.domains.calculator.internals.formatters.CalculatorFormatter


class Calculator(expression: String) {
    var expression: String = expression
        private set

    fun addCharacter(characters: Characters) {
        expression += characters.value
    }

    fun backspace() {
        expression = CalculatorFormatter.getCalculationExpressionWithoutLastCharacter(
            expression
        )
    }

    fun clean() {
        expression = ""
    }

    fun evaluate() {
        try {
            expression = ExpressionEvaluator.getEvaluatedCalculationExpression(expression)
        } catch (exception: Exception) {
            expression = ""

            throw exception
        }
    }
}