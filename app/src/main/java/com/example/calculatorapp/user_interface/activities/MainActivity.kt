package com.example.calculatorapp.user_interface.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.calculatorapp.user_interface.application.Application
import com.example.calculatorapp.user_interface.internals.adapters.RetrieveStoredCalculationExpressionAdapter
import com.example.calculatorapp.user_interface.view_models.CalculatorViewModel
import com.example.calculatorapp.user_interface.view_models.ThemeModeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val lastSessionCalculationExpression =
            RetrieveStoredCalculationExpressionAdapter.getStoredCalculationExpression(baseContext)

        val calculatorViewModel: CalculatorViewModel
                by viewModel { parametersOf(lastSessionCalculationExpression) }
        val themeModeViewModel: ThemeModeViewModel by viewModel()

        setContent {
            Application(calculatorViewModel, themeModeViewModel)
        }
    }
}