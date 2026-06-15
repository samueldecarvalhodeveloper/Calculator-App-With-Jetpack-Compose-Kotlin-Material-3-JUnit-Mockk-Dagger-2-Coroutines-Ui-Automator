package com.example.calculatorapp.user_interface.internals.adapters

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.calculatorapp.user_interface.data_stores.ExpressionDataStore
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EXPRESSION_TO_BE_EVALUATED
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

            ExpressionDataStore.setStoredExpression(
                EXPRESSION_TO_BE_EVALUATED,
                context
            )

            val retrievedCalculationExpression =
                RetrieveStoredCalculationExpressionAdapter.getStoredCalculationExpression(context)

            assertEquals(EXPRESSION_TO_BE_EVALUATED, retrievedCalculationExpression)
        }
    }
}