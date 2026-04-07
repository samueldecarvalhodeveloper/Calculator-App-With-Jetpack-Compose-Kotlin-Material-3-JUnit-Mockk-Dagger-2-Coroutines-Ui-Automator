package com.example.calculatorapp.user_interface.view_models

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calculatorapp.R
import com.example.calculatorapp.user_interface.internals.stores.CalculationExpressionStore
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import com.example.calculatorapp.domains.calculator.internals.checkers.CalculatorChecker.isCalculationExpressionNotValidExpressionExceptionMessage

open class CalculatorViewModel(
    private val calculator: Calculator,
    private var suspendedFunctionContext: ((suspend () -> Unit) -> Unit)? = null
) : ViewModel() {
    private val _calculationExpression: MutableState<String>  = mutableStateOf("")
    val calculationExpression: State<String> = _calculationExpression

    open fun loadCalculationExpression(context: Context) {
        val currentCalculationExpression = calculator.getCalculationExpression()

        _calculationExpression.value = if (isCalculationExpressionNotValidExpressionExceptionMessage(
                currentCalculationExpression
            )
        ) context.getString(R.string.not_valid_expression_message) else currentCalculationExpression
    }

    open fun addCharacter(calculatorCharacters: CalculatorCharacters, context: Context) {
        calculator.addCharacter(calculatorCharacters)

        val currentCalculationExpression = calculator.getCalculationExpression()

        _calculationExpression.value = currentCalculationExpression

        suspendedFunctionContext?.invoke {
            CalculationExpressionStore.setStoredCalculationExpression(
                currentCalculationExpression,
                context
            )
        }
    }

    open fun backspace(context: Context) {
        calculator.backspace()

        val currentCalculationExpression = calculator.getCalculationExpression()

        _calculationExpression.value = currentCalculationExpression

        suspendedFunctionContext?.invoke {
            CalculationExpressionStore.setStoredCalculationExpression(
                currentCalculationExpression,
                context
            )
        }
    }

    open fun clean(context: Context) {
        calculator.clean()

        val currentCalculationExpression = calculator.getCalculationExpression()

        _calculationExpression.value = currentCalculationExpression

        suspendedFunctionContext?.invoke {
            CalculationExpressionStore.setStoredCalculationExpression(
                currentCalculationExpression,
                context
            )
        }
    }

    open fun evaluate(context: Context) {
        calculator.evaluate()

        val currentCalculationExpression = calculator.getCalculationExpression()

        _calculationExpression.value =
            if (isCalculationExpressionNotValidExpressionExceptionMessage(
                    currentCalculationExpression
                )
            ) context.getString(R.string.not_valid_expression_message) else currentCalculationExpression

        suspendedFunctionContext?.invoke {
            CalculationExpressionStore.setStoredCalculationExpression(
                currentCalculationExpression,
                context
            )
        }
    }
}