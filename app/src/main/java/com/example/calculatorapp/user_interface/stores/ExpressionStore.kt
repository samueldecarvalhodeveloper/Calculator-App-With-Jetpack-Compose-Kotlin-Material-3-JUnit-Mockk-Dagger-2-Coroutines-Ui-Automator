package com.example.calculatorapp.user_interface.stores

import android.content.Context
import com.example.calculatorapp.constants.LAST_SESSION_EXPRESSION_KEY
import com.example.calculatorapp.infrastructure.adapters.KeyValueDatabase
import com.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException

class ExpressionStore {
    companion object {
        suspend fun getStoredExpression(context: Context): String {
            try {
                return KeyValueDatabase.getStringValue(
                    LAST_SESSION_EXPRESSION_KEY,
                    context
                )
            } catch (_: NotExistingKeyException) {
                KeyValueDatabase.setStringValue(
                    LAST_SESSION_EXPRESSION_KEY, "",
                    context
                )

                return ""
            }
        }

        suspend fun setStoredExpression(
            newCalculationExpression: String,
            context: Context
        ) {
            KeyValueDatabase.setStringValue(
                LAST_SESSION_EXPRESSION_KEY,
                newCalculationExpression, context
            )
        }
    }
}