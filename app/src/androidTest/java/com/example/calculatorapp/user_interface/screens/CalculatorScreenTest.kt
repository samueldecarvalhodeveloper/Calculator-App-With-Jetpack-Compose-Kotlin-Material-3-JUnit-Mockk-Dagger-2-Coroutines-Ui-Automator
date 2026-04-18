package com.example.calculatorapp.user_interface.screens

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.calculatorapp.R
import com.example.calculatorapp.constants.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.constants.STORING_VALUE_DELAY
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.domains.calculator.Characters
import com.example.calculatorapp.user_interface.internals.enums.CalculatorCharacters
import com.example.calculatorapp.user_interface.stores.ThemeStore
import com.example.calculatorapp.user_interface.view_models.CalculatorViewModel
import com.example.calculatorapp.user_interface.view_models.ThemeModeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

class CalculatorScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun beforeEach() {
        composeTestRule.setContent {
            CalculatorScreen(
                calculatorViewModel = calculationViewModel,
                themeModeViewModel = themeModeViewModel
            )
        }
        runTest {
            ThemeStore.setNightModeThemeState(false,context)
        }

        calculationViewModel.clean(context)
    }

    @Test
    fun testIfAllNumericalCharactersAreSetAndDispatchesAddCharacterWithItsCharacter() {
        composeTestRule.onNodeWithText(CalculatorCharacters.ZERO.value).assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.ONE.value).assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.TWO.value).assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.THREE.value).assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.FOUR.value).assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.FIVE.value).assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.SIX.value).assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.SEVEN.value).assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.EIGHT.value).assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.NINE.value).assertExists()

        composeTestRule.onNodeWithText(CalculatorCharacters.ZERO.value).performClick()

        assertEquals(
                CalculatorCharacters.ZERO.value,
                calculationViewModel.expression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(CalculatorCharacters.ONE.value).performClick()

        assertEquals(
                CalculatorCharacters.ONE.value,
                calculationViewModel.expression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(CalculatorCharacters.TWO.value).performClick()

        assertEquals(
                CalculatorCharacters.TWO.value,
                calculationViewModel.expression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(CalculatorCharacters.THREE.value).performClick()

        assertEquals(
                CalculatorCharacters.THREE.value,
                calculationViewModel.expression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(CalculatorCharacters.FOUR.value).performClick()

        assertEquals(
                CalculatorCharacters.FOUR.value,
                calculationViewModel.expression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(CalculatorCharacters.FIVE.value).performClick()

        assertEquals(
                CalculatorCharacters.FIVE.value,
                calculationViewModel.expression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(CalculatorCharacters.SIX.value).performClick()

        assertEquals(
                CalculatorCharacters.SIX.value,
                calculationViewModel.expression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(CalculatorCharacters.SEVEN.value).performClick()

        assertEquals(
                CalculatorCharacters.SEVEN.value,
                calculationViewModel.expression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(CalculatorCharacters.EIGHT.value).performClick()

        assertEquals(
                CalculatorCharacters.EIGHT.value,
                calculationViewModel.expression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(CalculatorCharacters.NINE.value).performClick()

        assertEquals(
                CalculatorCharacters.NINE.value,
                calculationViewModel.expression.value
            )
    }

    @Test
    fun testIfAllSymbolsCharactersIsSetAndDispatchesAddCharacterWithItsCharacter() {
        composeTestRule.onNodeWithText(CalculatorCharacters.POINT.value).assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.POINT.value).performClick()

        assertEquals(
                CalculatorCharacters.POINT.value,
                calculationViewModel.expression.value
            )
    }

    @Test
    fun testIfAllOperatorsCharactersAreSetAndDispatchesAddCharacterWithItsCharacter() {
        composeTestRule.onNodeWithText(CalculatorCharacters.ADDITION.value)
            .assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.ADDITION.value)
            .performClick()

        assertEquals(
                CalculatorCharacters.ADDITION.value,
                calculationViewModel.expression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(CalculatorCharacters.SUBTRACTION.value)
            .assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.SUBTRACTION.value)
            .performClick()

        assertEquals(
                CalculatorCharacters.SUBTRACTION.value,
                calculationViewModel.expression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(CalculatorCharacters.MULTIPLICATION.value)
            .assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.MULTIPLICATION.value)
            .performClick()

        assertEquals(
                CalculatorCharacters.MULTIPLICATION.value,
                calculationViewModel.expression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(CalculatorCharacters.DIVISION.value)
            .assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.DIVISION.value)
            .performClick()

        assertEquals(
                CalculatorCharacters.DIVISION.value,
                calculationViewModel.expression.value
            )
    }

    @Test
    fun testIfClearCharacterButtonIsSetAndDispatchesCleanViewModelMethod() {
        calculationViewModel.addCharacter(Characters.ONE, context)

        composeTestRule.onNodeWithText(CalculatorCharacters.CLEAN.value)
            .assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.CLEAN.value)
            .performClick()

        assertEquals(
                "",
                calculationViewModel.expression.value
            )
    }

    @Test
    fun testIfBackspaceCharacterButtonIsSetAndDispatchesBackspaceViewModelMethod() {
        calculationViewModel.addCharacter(Characters.ONE, context)

        composeTestRule.onNodeWithText(CalculatorCharacters.BACKSPACE.value)
            .assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.BACKSPACE.value)
            .performClick()

        assertEquals(
            "",
            calculationViewModel.expression.value
        )
    }

    @Test
    fun testIfAllEvaluateCharactersIsSetAndDispatchesEvaluateViewModelMethod() {
        calculationViewModel.addCharacter(Characters.ONE, context)
        calculationViewModel.addCharacter(Characters.ADDITION, context)
        calculationViewModel.addCharacter(Characters.ONE, context)

        composeTestRule.onNodeWithText(CalculatorCharacters.EVALUATION.value)
            .assertExists()
        composeTestRule.onNodeWithText(CalculatorCharacters.EVALUATION.value)
            .performClick()

        assertEquals(
            EVALUATED_SIMPLE_CALCULATION_EXPRESSION,
            calculationViewModel.expression.value
        )
    }

    @Test
    fun testIfActionBarActionButtonTogglesThemeMode() = runBlocking {
        val initialNightThemeState = ThemeStore.getNightModeThemeState(context)
        val actionbarMenuToggleNightModeContentDescription =
            context.getString(R.string.actionbar_menu_toggle_night_mode_content_description)

        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .assertExists()
        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()

        delay(STORING_VALUE_DELAY)

        val currentNightThemeState = ThemeStore.getNightModeThemeState(context)

        assertNotEquals(currentNightThemeState, initialNightThemeState)
    }

    companion object {
        private lateinit var context: Context
        private lateinit var calculationViewModel: CalculatorViewModel
        private lateinit var themeModeViewModel: ThemeModeViewModel

        @BeforeClass
        @JvmStatic
        fun beforeAll() {
            val calculator = Calculator("")

            context = InstrumentationRegistry.getInstrumentation().targetContext

            calculationViewModel = CalculatorViewModel(calculator)
            themeModeViewModel = ThemeModeViewModel()
        }
    }
}