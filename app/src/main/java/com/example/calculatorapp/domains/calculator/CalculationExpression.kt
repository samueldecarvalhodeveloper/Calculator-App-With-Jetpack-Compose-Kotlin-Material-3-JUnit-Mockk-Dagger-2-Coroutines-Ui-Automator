package com.example.calculatorapp.domains.calculator

import com.example.calculatorapp.domains.calculator.internals.adapters.ExpressionEvaluator
import com.example.calculatorapp.domains.calculator.internals.formatters.CalculatorFormatter

open class CalculationExpression(private var calculationExpression: String) {
    open fun getCalculationExpression(): String {
        return calculationExpression
    }

    open fun addCharacterToCalculationExpression(character: CalculatorCharacters) {
        calculationExpression += character.value
    }

    open fun removeLastCharacterFromCalculationExpression() {
        val currentCalculationExpressionWithoutLastCharacter =
            CalculatorFormatter.getCalculationExpressionWithoutLastCharacter(
                calculationExpression
            )

        calculationExpression = currentCalculationExpressionWithoutLastCharacter
    }

    open fun turnCalculationExpressionEmpty() {
        calculationExpression = ""
    }

    open fun evaluateCalculationExpression() {
        val evaluatedCalculationExpression =
            ExpressionEvaluator.getEvaluatedCalculationExpression(calculationExpression)

        calculationExpression = evaluatedCalculationExpression
    }
}