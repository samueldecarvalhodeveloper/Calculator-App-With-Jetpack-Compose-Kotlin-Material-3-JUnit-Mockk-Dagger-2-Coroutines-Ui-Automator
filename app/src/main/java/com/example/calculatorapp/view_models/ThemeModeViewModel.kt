package com.example.calculatorapp.view_models

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import kotlinx.coroutines.launch

open class ThemeModeViewModel : ViewModel() {
    private var themeMode = MutableLiveData(false)

    open fun getThemeMode(context: Context): MutableLiveData<Boolean> {
        viewModelScope.launch {
            val storedTheme = UserInterfaceThemeStore.getNightModeThemeState(context)

            themeMode.value = storedTheme
        }

        return themeMode
    }

    open fun toggleTheme(context: Context) {
        themeMode.value = !(themeMode.value as Boolean)

        viewModelScope.launch {
            UserInterfaceThemeStore.setNightModeThemeState(themeMode.value as Boolean, context)
        }
    }
}