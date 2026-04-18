package com.example.calculatorapp.dependency_injection

import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.user_interface.view_models.CalculatorViewModel
import com.example.calculatorapp.user_interface.view_models.ThemeModeViewModel
import org.koin.dsl.module

val applicationModule = module {
    single { Calculator(get()) }

    single { CalculatorViewModel(get()) }

    single { ThemeModeViewModel() }
}