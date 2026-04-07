package com.example.calculatorapp.user_interface.application

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.calculatorapp.user_interface.screens.CalculatorScreen
import com.example.calculatorapp.user_interface.theme.Theme
import com.example.calculatorapp.user_interface.view_models.CalculatorViewModel
import com.example.calculatorapp.user_interface.view_models.ThemeModeViewModel

@Composable
fun Application(
    calculatorViewModel: CalculatorViewModel,
    themeModeViewModel: ThemeModeViewModel
) {
    val context = LocalContext.current

    Theme(isThemeDark = themeModeViewModel.themeMode.value) {
        CalculatorScreen(calculatorViewModel, themeModeViewModel)
    }
}
