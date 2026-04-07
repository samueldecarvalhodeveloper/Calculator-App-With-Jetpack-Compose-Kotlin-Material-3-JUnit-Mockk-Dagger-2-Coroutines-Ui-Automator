package com.example.calculatorapp.user_interface.screens

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.calculatorapp.R
import com.example.calculatorapp.constants.STORING_VALUE_DELAY
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.CalculationExpressionDecorator
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import com.example.calculatorapp.user_interface.internals.enums.UserInterfaceCalculatorCharacters
import com.example.calculatorapp.user_interface.internals.stores.UserInterfaceThemeStore
import com.example.calculatorapp.user_interface.view_models.CalculatorViewModel
import com.example.calculatorapp.user_interface.view_models.ThemeModeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
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

        calculationViewModel.clean(context)
    }

    @Test
    fun testIfCalculatorViewModelCalculationExpressionValueIsLoadedOnFirstComposition() = runBlocking {
        assertEquals(
            "",
            calculationViewModel.calculationExpression.value
        )
    }

    @Test
    fun testIfAllNumericalCharactersAreSetAndDispatchesAddCharacterWithItsCharacter() {
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ZERO.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.TWO.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.THREE.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.FOUR.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.FIVE.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.SIX.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.SEVEN.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.EIGHT.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.NINE.value).assertExists()

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ZERO.value).performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.ZERO.value,
                calculationViewModel.calculationExpression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.ONE.value,
                calculationViewModel.calculationExpression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.TWO.value).performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.TWO.value,
                calculationViewModel.calculationExpression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.THREE.value).performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.THREE.value,
                calculationViewModel.calculationExpression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.FOUR.value).performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.FOUR.value,
                calculationViewModel.calculationExpression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.FIVE.value).performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.FIVE.value,
                calculationViewModel.calculationExpression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.SIX.value).performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.SIX.value,
                calculationViewModel.calculationExpression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.SEVEN.value).performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.SEVEN.value,
                calculationViewModel.calculationExpression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.EIGHT.value).performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.EIGHT.value,
                calculationViewModel.calculationExpression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.NINE.value).performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.NINE.value,
                calculationViewModel.calculationExpression.value
            )
    }

    @Test
    fun testIfAllSymbolsCharactersIsSetAndDispatchesAddCharacterWithItsCharacter() {
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.POINT.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.POINT.value).performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.POINT.value,
                calculationViewModel.calculationExpression.value
            )
    }

    @Test
    fun testIfAllOperatorsCharactersAreSetAndDispatchesAddCharacterWithItsCharacter() {
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ADDITION.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ADDITION.value)
            .performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.ADDITION.value,
                calculationViewModel.calculationExpression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.SUBTRACTION.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.SUBTRACTION.value)
            .performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.SUBTRACTION.value,
                calculationViewModel.calculationExpression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.MULTIPLICATION.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.MULTIPLICATION.value)
            .performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.MULTIPLICATION.value,
                calculationViewModel.calculationExpression.value
            )

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.DIVISION.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.DIVISION.value)
            .performClick()

        assertEquals(
                UserInterfaceCalculatorCharacters.DIVISION.value,
                calculationViewModel.calculationExpression.value
            )
    }

    @Test
    fun testIfClearCharacterButtonIsSetAndDispatchesCleanViewModelMethod() {
        calculationViewModel.addCharacter(CalculatorCharacters.ONE, context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.CLEAN.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.CLEAN.value)
            .performClick()

        assertEquals(
                "",
                calculationViewModel.calculationExpression.value
            )
    }

    @Test
    fun testIfBackspaceCharacterButtonIsSetAndDispatchesBackspaceViewModelMethod() {
        calculationViewModel.addCharacter(CalculatorCharacters.ONE, context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.BACKSPACE.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.BACKSPACE.value)
            .performClick()

        assertEquals(
            "",
            calculationViewModel.calculationExpression.value
        )
    }

    @Test
    fun testIfAllEvaluateCharactersIsSetAndDispatchesEvaluateViewModelMethod() {
        calculationViewModel.addCharacter(CalculatorCharacters.ONE, context)
        calculationViewModel.addCharacter(CalculatorCharacters.ADDITION, context)
        calculationViewModel.addCharacter(CalculatorCharacters.ONE, context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value)
            .performClick()

        assertEquals(
            EVALUATED_SIMPLE_CALCULATION_EXPRESSION,
            calculationViewModel.calculationExpression.value
        )
    }

    @Test
    fun testIfActionBarActionButtonTogglesThemeMode() = runBlocking {
        val initialNightThemeState = UserInterfaceThemeStore.getNightModeThemeState(context)
        val actionbarMenuToggleNightModeContentDescription =
            context.getString(R.string.actionbar_menu_toggle_night_mode_content_description)

        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .assertExists()
        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()

        delay(STORING_VALUE_DELAY)

        val currentNightThemeState = UserInterfaceThemeStore.getNightModeThemeState(context)

        assertNotEquals(currentNightThemeState, initialNightThemeState)
    }

    companion object {
        private lateinit var context: Context
        private lateinit var calculationViewModel: CalculatorViewModel
        private lateinit var themeModeViewModel: ThemeModeViewModel

        @BeforeClass
        @JvmStatic
        fun beforeAll() {
            val calculationExpressionRegister = CalculationExpressionDecorator("")
            val calculator = Calculator(calculationExpressionRegister)

            context = InstrumentationRegistry.getInstrumentation().targetContext

            calculationViewModel = CalculatorViewModel(calculator)
            themeModeViewModel = ThemeModeViewModel()
        }
    }
}