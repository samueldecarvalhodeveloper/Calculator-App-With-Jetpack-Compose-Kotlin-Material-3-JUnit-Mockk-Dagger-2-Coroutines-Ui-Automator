package com.example.calculatorapp.infrastructure.adapters

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.calculatorapp.constants.LAST_SESSION_EXPRESSION_KEY
import com.example.calculatorapp.constants.THEME_KEY
import com.example.calculatorapp.constants.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class KeyValueDatabaseTest {
    lateinit var context: Context

    @Before
    fun beforeEach() {
        context = ApplicationProvider.getApplicationContext()

        stopKoin()
    }

    @Test
    fun testIfBooleanValueIsStoredInDatabase() {
        runBlocking {
            KeyValueDatabase.setBooleanValue(THEME_KEY, true, context)

            val retrievedValue = KeyValueDatabase.getBooleanValue(THEME_KEY, context)

            assertTrue(retrievedValue)
        }
    }

    @Test
    fun testIfStringValueIsStoredInDatabase() {
        runBlocking {
            KeyValueDatabase.setStringValue(
                LAST_SESSION_EXPRESSION_KEY,
                SIMPLE_CALCULATION_EXPRESSION,
                context
            )

            val retrievedValue =
                KeyValueDatabase.getStringValue(LAST_SESSION_EXPRESSION_KEY, context)

            assertEquals(SIMPLE_CALCULATION_EXPRESSION, retrievedValue)
        }
    }
}