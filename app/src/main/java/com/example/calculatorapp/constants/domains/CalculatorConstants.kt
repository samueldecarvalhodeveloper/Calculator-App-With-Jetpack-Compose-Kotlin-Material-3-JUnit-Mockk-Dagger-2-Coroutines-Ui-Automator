package com.example.calculatorapp.constants.domains

class CalculatorConstants {
    companion object {
        const val NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE: String = "Error (Not Valid Expression)"
        const val EXPRESSION_TO_BE_EVALUATED: String = "1+1"
        const val EXPRESSION_TO_BE_EVALUATED_WITHOUT_LAST_CHARACTER: String = "1+"
        const val EVALUATED_SIMPLE_CALCULATION_EXPRESSION: String = "2"
        const val NOT_VALID_CALCULATION_EXPRESSION: String = "++"
        const val NUMBER_WITH_REST: Double = 1.1
        const val NUMBER_WITHOUT_REST: Double = 1.0
        const val INFINITY_EXPRESSION = "0/0"
        const val NOT_A_NUMBER_EXPRESSION = "1/0"
    }
}