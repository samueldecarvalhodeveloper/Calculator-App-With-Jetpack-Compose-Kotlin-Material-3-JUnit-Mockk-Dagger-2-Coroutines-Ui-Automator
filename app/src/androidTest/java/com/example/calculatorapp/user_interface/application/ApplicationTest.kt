package com.example.calculatorapp.user_interface.application

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.calculatorapp.R
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.user_interface.internals.enums.CalculatorCharacters
import com.example.calculatorapp.user_interface.stores.ThemeStore
import com.example.calculatorapp.user_interface.view_models.CalculatorViewModel
import com.example.calculatorapp.user_interface.view_models.ThemeModeViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

class ApplicationTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun beforeEach() {
        composeTestRule.setContent {
            Application(calculationViewModel, themeModeViewModel)
        }
    }

    @Test
    fun testIfApplicationComponentsSetsUpAllAppNeededDependencies() {
        val actionbarMenuToggleNightModeContentDescription =
            context.getString(R.string.actionbar_menu_toggle_night_mode_content_description)

        composeTestRule.onNodeWithText(CalculatorCharacters.ONE.value).assertExists()
        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .assertExists()
    }

    companion object {
        private lateinit var calculationViewModel: CalculatorViewModel
        private lateinit var themeModeViewModel: ThemeModeViewModel

        @JvmStatic
        @BeforeClass
        fun beforeAll() {
            val calculator = Calculator("")

            calculationViewModel = CalculatorViewModel(calculator)
            themeModeViewModel = ThemeModeViewModel()
        }
    }
}