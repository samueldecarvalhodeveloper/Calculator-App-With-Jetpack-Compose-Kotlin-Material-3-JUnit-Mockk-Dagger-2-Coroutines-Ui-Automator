package com.example.calculatorapp.user_interface.view_models

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculatorapp.user_interface.internals.stores.UserInterfaceThemeStore
import kotlinx.coroutines.launch

open class ThemeModeViewModel(
    private var suspendedFunctionContext: ((suspend () -> Unit) -> Unit)? = null)
    : ViewModel() {
    private var _themeMode = mutableStateOf(false)
    val themeMode: State<Boolean> = _themeMode

    init {
        if(suspendedFunctionContext == null) {
            suspendedFunctionContext = {
                viewModelScope.launch {
                    it()
                }
            }
        }
    }

    open fun loadTheme(context: Context) {
        suspendedFunctionContext?.invoke {
            val storedTheme = UserInterfaceThemeStore.getNightModeThemeState(context)

            _themeMode.value = storedTheme
        }
    }

    open fun toggleTheme(context: Context) {
        _themeMode.value = !_themeMode.value

        suspendedFunctionContext?.invoke {
            UserInterfaceThemeStore.setNightModeThemeState(themeMode.value, context)
        }
    }
}