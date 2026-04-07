package com.example.calculatorapp.dependency_injection

import com.example.calculatorapp.domains.calculator.CalculationExpression
import com.example.calculatorapp.domains.calculator.CalculationExpressionDecorator
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.user_interface.view_models.CalculatorViewModel
import com.example.calculatorapp.user_interface.view_models.ThemeModeViewModel
import org.koin.dsl.module

val applicationModule = module {
    single<CalculationExpression> {
        CalculationExpressionDecorator(get())
    }

    single { Calculator(get()) }

    single { CalculatorViewModel(get()) }

    single { ThemeModeViewModel() }
}