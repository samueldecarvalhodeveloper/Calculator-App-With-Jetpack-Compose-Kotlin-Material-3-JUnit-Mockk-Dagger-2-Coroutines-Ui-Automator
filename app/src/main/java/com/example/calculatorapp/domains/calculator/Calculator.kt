package com.example.calculatorapp.domains.calculator

import com.example.calculatorapp.domains.calculator.internals.checkers.CalculatorChecker.isCalculationExpressionEmpty

class Calculator(private val calculationExpression: CalculationExpression) {
    fun getCalculationExpression(): String {
        return calculationExpression.getCalculationExpression()
    }

    fun addCharacter(calculatorCharacters: CalculatorCharacters) {
        calculationExpression.addCharacterToCalculationExpression(calculatorCharacters)
    }

    fun backspace() {
        val currentCalculationExpression =
            calculationExpression.getCalculationExpression()

        if (isCalculationExpressionEmpty(currentCalculationExpression)) return

        calculationExpression.removeLastCharacterFromCalculationExpression()
    }

    fun clean() {
        val currentCalculationExpression =
            calculationExpression.getCalculationExpression()

        if (isCalculationExpressionEmpty(currentCalculationExpression)) return

        calculationExpression.turnCalculationExpressionEmpty()
    }

    fun evaluate() {
        val currentCalculationExpression =
            calculationExpression.getCalculationExpression()

        if (isCalculationExpressionEmpty(currentCalculationExpression)) return

        calculationExpression.evaluateCalculationExpression()
    }
}