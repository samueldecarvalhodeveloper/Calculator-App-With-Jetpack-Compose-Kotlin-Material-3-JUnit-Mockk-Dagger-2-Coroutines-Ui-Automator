package com.example.calculatorapp.user_interface.components.keyboard

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.calculatorapp.user_interface.components.button.Button
import com.example.calculatorapp.user_interface.theme.Theme
import com.example.calculatorapp.user_interface.internals.enums.UserInterfaceCalculatorCharacters
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class KeyboardTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun beforeEach() {
        composeTestRule.setContent {
            Keyboard {
                Button(
                    character = UserInterfaceCalculatorCharacters.ONE,
                    characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                    backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                    borderColor = Theme.colors.primaryBlueButtonBorderColor
                ) {
                }
            }
        }
    }

    @Test
    fun testIfComponentIsRendered() {
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).assertExists()
    }
}
