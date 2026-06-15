package com.example.calculatorapp.user_interface.internals.adapters

import android.content.Context
import com.example.calculatorapp.user_interface.data_stores.ExpressionDataStore
import kotlinx.coroutines.runBlocking

class RetrieveStoredCalculationExpressionAdapter {
    companion object {
        fun getStoredCalculationExpression(context: Context): String {
            lateinit var storedCalculationExpression: String

            runBlocking {
                storedCalculationExpression =
                    ExpressionDataStore.getStoredExpression(context)
            }

            return storedCalculationExpression
        }
    }
}