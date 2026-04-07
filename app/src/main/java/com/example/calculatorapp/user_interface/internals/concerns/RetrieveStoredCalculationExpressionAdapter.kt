package com.example.calculatorapp.user_interface.internals.concerns

import android.content.Context
import com.example.calculatorapp.user_interface.internals.stores.CalculationExpressionStore
import kotlinx.coroutines.runBlocking

class RetrieveStoredCalculationExpressionAdapter {
    companion object {
        fun getStoredCalculationExpression(context: Context): String {
            lateinit var storedCalculationExpression: String

            runBlocking {
                storedCalculationExpression =
                    CalculationExpressionStore.getStoredCalculationExpression(context)
            }

            return storedCalculationExpression
        }
    }
}