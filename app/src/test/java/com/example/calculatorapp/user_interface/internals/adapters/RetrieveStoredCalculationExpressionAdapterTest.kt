package com.example.calculatorapp.user_interface.internals.adapters

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.calculatorapp.user_interface.stores.ExpressionStore
import com.example.calculatorapp.constants.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RetrieveStoredCalculationExpressionAdapterTest {
    @Before
    fun beforeEach() {
        stopKoin()
    }

    @Test
    fun testIfClassHandleCalculationExpressionStoringOnKeyValueDatabase() {
        runBlocking {
            val context = ApplicationProvider.getApplicationContext<Context>()

            ExpressionStore.setStoredExpression(
                SIMPLE_CALCULATION_EXPRESSION,
                context
            )

            val retrievedCalculationExpression =
                RetrieveStoredCalculationExpressionAdapter.getStoredCalculationExpression(context)

            assertEquals(SIMPLE_CALCULATION_EXPRESSION, retrievedCalculationExpression)
        }
    }
}