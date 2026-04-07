package com.example.calculatorapp.user_interface.view_models

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.calculatorapp.R
import com.example.calculatorapp.domains.calculator.CalculationExpressionDecorator
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import com.example.calculatorapp.user_interface.internals.stores.CalculationExpressionStore
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
        val calculationExpressionRegister = CalculationExpressionDecorator("")

        stopKoin()

        calculator = Calculator(calculationExpressionRegister)

        context = ApplicationProvider.getApplicationContext()

        calculatorViewModel = CalculatorViewModel(calculator) {
            runBlocking { it() }
        }
    }

    @Test
    fun testIfMethodLoadCalculationExpressionLoadsCalculationExpressionAndSetDeviceLanguageNotValidExpressionMessageIfInitialCalculatorIsExpressionNotValidExpressionMessage() {
        calculator.addCharacter(CalculatorCharacters.ONE)
        calculator.addCharacter(CalculatorCharacters.ADDITION)
        calculator.evaluate()

        calculatorViewModel.loadCalculationExpression(context)

        assertEquals(
            context.getString(R.string.not_valid_expression_message),
            calculatorViewModel.calculationExpression.value
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodAddCharacterAddsCharacterToCalculationExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

            assertEquals(
                CalculatorCharacters.ONE.value,
                calculatorViewModel.calculationExpression.value
            )

            val storedCalculationExpression =
                CalculationExpressionStore.getStoredCalculationExpression(context)

            assertEquals(
                CalculatorCharacters.ONE.value,
                storedCalculationExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodBackspaceRemovesLastCharacterFromCalculationExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)
            calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

            calculatorViewModel.backspace(context)

            advanceUntilIdle()

            assertEquals(
                CalculatorCharacters.ONE.value,
                calculatorViewModel.calculationExpression.value
            )

            val storedCalculationExpression =
                CalculationExpressionStore.getStoredCalculationExpression(context)

            assertEquals(
                CalculatorCharacters.ONE.value,
                storedCalculationExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodCleanRemovesAllCharactersFromCalculationExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)
            calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

            calculatorViewModel.clean(context)

            advanceUntilIdle()

            assertEquals(
                "",
                calculatorViewModel.calculationExpression.value
            )

            val storedCalculationExpression =
                CalculationExpressionStore.getStoredCalculationExpression(context)

            assertEquals(
                "",
                storedCalculationExpression
            )
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodEvaluateEvaluatesCalculationExpressionAndStoresOnKeyValueDatabase() =
        runTest {
            calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)
            calculatorViewModel.addCharacter(CalculatorCharacters.ADDITION, context)
            calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

            calculatorViewModel.evaluate(context)

            advanceUntilIdle()

            assertEquals(
                CalculatorCharacters.TWO.value,
                calculatorViewModel.calculationExpression.value
            )

            val storedCalculationExpression =
                CalculationExpressionStore.getStoredCalculationExpression(context)

            assertEquals(
                CalculatorCharacters.TWO.value,
                storedCalculationExpression
            )
        }
}