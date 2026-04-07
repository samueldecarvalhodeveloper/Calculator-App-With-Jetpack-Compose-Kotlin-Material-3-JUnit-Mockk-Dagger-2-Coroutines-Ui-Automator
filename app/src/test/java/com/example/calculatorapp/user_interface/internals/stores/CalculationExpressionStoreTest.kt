package com.example.calculatorapp.user_interface.internals.stores

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.calculatorapp.constants.CalculatorConstants
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CalculationExpressionStoreTest {
    @Before
    fun beforeEach() {
        stopKoin()
    }

    @Test
    fun testIfClassHandleCalculationExpressionStoringOnKeyValueDatabase() {
        runBlocking {
            val context = ApplicationProvider.getApplicationContext<Context>()

            CalculationExpressionStore.setStoredCalculationExpression(
                CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION,
            context
            )

            val retrievedCalculationExpression =
                CalculationExpressionStore.getStoredCalculationExpression(context)

            Assert.assertEquals(
                CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION,
                retrievedCalculationExpression
            )
        }
    }
}