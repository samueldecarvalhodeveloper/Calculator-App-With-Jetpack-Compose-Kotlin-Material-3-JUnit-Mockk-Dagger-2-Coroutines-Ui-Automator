package com.example.calculatorapp.user_interface.internals.stores

import android.content.Context
import com.example.calculatorapp.constants.LAST_SESSION_CALCULATION_EXPRESSION_KEY
import com.example.calculatorapp.infrastructure.adapters.KeyValueDatabase
import com.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException

class CalculationExpressionStore {
    companion object {
        suspend fun getStoredCalculationExpression(context: Context): String {
            try {
                return KeyValueDatabase.Companion.getStringValue(
                    LAST_SESSION_CALCULATION_EXPRESSION_KEY,
                    context
                )
            } catch (exception: NotExistingKeyException) {
                KeyValueDatabase.Companion.setStringValue(
                    LAST_SESSION_CALCULATION_EXPRESSION_KEY, "",
                    context
                )

                return ""
            }
        }

        suspend fun setStoredCalculationExpression(
            newCalculationExpression: String,
            context: Context
        ) {
            KeyValueDatabase.Companion.setStringValue(
                LAST_SESSION_CALCULATION_EXPRESSION_KEY,
                newCalculationExpression, context
            )
        }
    }
}