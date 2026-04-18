package com.example.calculatorapp.user_interface.view_models

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.calculatorapp.R
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.domains.calculator.Characters
import com.example.calculatorapp.user_interface.stores.ExpressionStore
import kotlinx.coroutines.ExperimentalCoroutinesApi

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CalculatorViewModelTest {
    lateinit var calculator: Calculator
    lateinit var calculatorViewModel: CalculatorViewModel
    lateinit var context: Context

    @Before
    fun beforeEach() = runTest {
        stopKoin()

        calculator = Calculator("")

        context = ApplicationProvider.getApplicationContext()

        calculatorViewModel = CalculatorViewModel(calculator) {
            runBlocking { it() }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodAddCharacterAddsCharacterToExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculatorViewModel.addCharacter(Characters.ONE, context)

            assertEquals(
                Characters.ONE.value,
                calculatorViewModel.expression.value
            )

            val storedExpression =
                ExpressionStore.getStoredExpression(context)

            assertEquals(
                Characters.ONE.value,
                storedExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodBackspaceRemovesLastCharacterFromExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculator.addCharacter(Characters.ONE)
            calculator.addCharacter(Characters.ONE)

            calculatorViewModel.backspace(context)

            advanceUntilIdle()

            assertEquals(
                Characters.ONE.value,
                calculatorViewModel.expression.value
            )

            val storedExpression =
                ExpressionStore.getStoredExpression(context)

            assertEquals(
                Characters.ONE.value,
                storedExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodCleanRemovesAllCharactersFromExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculator.addCharacter(Characters.ONE)
            calculator.addCharacter(Characters.ONE)

            calculatorViewModel.clean(context)

            advanceUntilIdle()

            assertEquals(
                "",
                calculatorViewModel.expression.value
            )

            val storedExpression =
                ExpressionStore.getStoredExpression(context)

            assertEquals(
                "",
                storedExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodEvaluateEvaluatesExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculator.addCharacter(Characters.ONE)
            calculator.addCharacter(Characters.ADDITION)
            calculator.addCharacter(Characters.ONE)

            calculatorViewModel.evaluate(context)

            advanceUntilIdle()

            assertEquals(
                Characters.TWO.value,
                calculatorViewModel.expression.value
            )

            val storedExpression =
                ExpressionStore.getStoredExpression(context)

            assertEquals(
                Characters.TWO.value,
                storedExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodEvaluateTurnsUserInterfaceExpressionToNotValidExpressionMessageOnDeviceLanguageAndCalculatorExpressionStoresOnKeyValueDatabase() =
        runTest {
            calculator.addCharacter(Characters.ONE)
            calculator.addCharacter(Characters.ADDITION)

            calculatorViewModel.evaluate(context)

            advanceUntilIdle()

            assertEquals(
                context.getString(R.string.not_valid_expression_message),
                calculatorViewModel.expression.value
            )

            val storedExpression =
                ExpressionStore.getStoredExpression(context)

            assertEquals(
                "",
                storedExpression
            )
        }
}