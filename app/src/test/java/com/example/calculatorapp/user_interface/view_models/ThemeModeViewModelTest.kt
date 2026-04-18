package com.example.calculatorapp.user_interface.view_models

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.calculatorapp.user_interface.stores.ThemeStore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ThemeModeViewModelTest {
    lateinit var themeModeViewModel: ThemeModeViewModel
    lateinit var context: Context

    @Before
    fun beforeEach() = runTest {
        context = ApplicationProvider.getApplicationContext()
        themeModeViewModel = ThemeModeViewModel {
            runBlocking { it() }
        }

        ThemeStore.setNightModeThemeState(
            themeModeViewModel.themeMode.value,
            context
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfMethodToggleThemeTogglesThemeModeAndStoredOnKeyValueDatabase() = runTest {
        themeModeViewModel.toggleTheme(context)

        advanceUntilIdle()

        assertTrue(themeModeViewModel.themeMode.value)

        val storedThemeMode = ThemeStore.getNightModeThemeState(context)

        assertTrue(storedThemeMode)
    }
}
