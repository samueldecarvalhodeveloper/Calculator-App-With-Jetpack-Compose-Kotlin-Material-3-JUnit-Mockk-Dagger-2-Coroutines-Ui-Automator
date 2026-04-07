package com.example.calculatorapp.domains.calculator

import com.example.calculatorapp.domains.calculator.internals.checkers.CalculatorChecker.isCalculationExpressionEmpty
import com.example.calculatorapp.domains.calculator.internals.checkers.CalculatorChecker.isCalculationExpressionNotValidExpressionExceptionMessage

class CalculationExpressionDecorator(calculationExpression: String) :
    CalculationExpression(calculationExpression) {
    override fun addCharacterToCalculationExpression(character: CalculatorCharacters) {
        val currentCalculationExpression = super.getCalculationExpression()

        if (isCalculationExpressionNotValidExpressionExceptionMessage(currentCalculationExpression)) {
            super.turnCalculationExpressionEmpty()
        } else {
            super.addCharacterToCalculationExpression(character)
        }
    }

    override fun removeLastCharacterFromCalculationExpression() {
        val currentCalculationExpression = super.getCalculationExpression()

        if (isCalculationExpressionNotValidExpressionExceptionMessage(currentCalculationExpression)) {
            super.turnCalculationExpressionEmpty()
        } else {
            super.removeLastCharacterFromCalculationExpression()
        }
    }

    override fun evaluateCalculationExpression() {
        val currentCalculationExpression = super.getCalculationExpression()

        if (isCalculationExpressionNotValidExpressionExceptionMessage(currentCalculationExpression) ||
            isCalculationExpressionEmpty(currentCalculationExpression)
        ) return

        super.evaluateCalculationExpression()
    }
}