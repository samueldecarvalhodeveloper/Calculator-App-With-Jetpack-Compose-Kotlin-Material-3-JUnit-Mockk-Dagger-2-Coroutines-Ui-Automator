package com.example.calculatorapp.user_interface.data_stores

import android.content.Context
import com.example.calculatorapp.constants.UserInterfaceConstants.THEME_KEY
import com.example.calculatorapp.infrastructure.adapters.KeyValueDatabase
import com.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException

class ThemeDataStore {
    companion object {
        suspend fun getNightModeThemeState(context: Context): Boolean {
            return try {
                KeyValueDatabase.getBooleanValue(THEME_KEY, context)
            } catch (_: NotExistingKeyException) {
                false
            }
        }

        suspend fun setNightModeThemeState(state: Boolean, context: Context) {
            KeyValueDatabase.setBooleanValue(THEME_KEY, state, context)
        }
    }
}