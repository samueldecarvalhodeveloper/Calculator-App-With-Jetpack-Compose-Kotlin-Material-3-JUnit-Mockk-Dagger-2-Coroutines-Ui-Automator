package com.example.calculatorapp.user_interface.components.button

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.calculatorapp.user_interface.theme.Theme
import com.example.calculatorapp.user_interface.internals.enums.CalculatorCharacters
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private var state = false

    @Before
    fun beforeEach() {
        composeTestRule.setContent {
            Button(
                CalculatorCharacters.ONE,
                Theme.colors.primaryBlueButtonCharacterColor,
                Theme.colors.primaryBlueButtonBackgroundColor,
                Theme.colors.primaryBlueButtonBorderColor
            ) {
                state = !state
            }
        }
    }

    @Test
    fun testIfComponentIsRenderedAndDispatchesItsEvent() {
        composeTestRule.onNodeWithText(CalculatorCharacters.ONE.value).performClick()

        assertTrue(state)
    }
}
