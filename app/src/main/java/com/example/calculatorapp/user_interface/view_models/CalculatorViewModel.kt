package com.example.calculatorapp.user_interface.view_models

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calculatorapp.R
import com.example.calculatorapp.user_interface.stores.ExpressionStore
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.domains.calculator.Characters

open class CalculatorViewModel(
    private val calculator: Calculator,
    private var suspendedFunctionContext: ((suspend () -> Unit) -> Unit)? = null
) : ViewModel() {
    private val _expression: MutableState<String> = mutableStateOf(calculator.expression)
    val expression: State<String> = _expression

        open fun addCharacter(characters: Characters, context: Context) {
        calculator.addCharacter(characters)

        _expression.value = calculator.expression

        suspendedFunctionContext?.invoke {
            ExpressionStore.setStoredExpression(
                calculator.expression,
                context
            )
        }
    }

    open fun backspace(context: Context) {
        calculator.backspace()

        _expression.value = calculator.expression

        suspendedFunctionContext?.invoke {
            ExpressionStore.setStoredExpression(
                calculator.expression,
                context
            )
        }
    }

    open fun clean(context: Context) {
        calculator.clean()

        _expression.value = calculator.expression

        suspendedFunctionContext?.invoke {
            ExpressionStore.setStoredExpression(
                calculator.expression,
                context
            )
        }
    }

    open fun evaluate(context: Context) {
        try {
            calculator.evaluate()

            _expression.value = calculator.expression
        } catch (_: Exception) {
            _expression.value = context.getString(R.string.not_valid_expression_message)
        }

        suspendedFunctionContext?.invoke{
            ExpressionStore.setStoredExpression(calculator.expression, context)
        }
    }
}