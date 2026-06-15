package com.example.calculatorapp.user_interface.data_stores

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ThemeDataStoreTest {
    @Before
    fun beforeEach() {
        stopKoin()
    }

    @Test
    fun testIfClassHandleThemeStoringOnKeyValueDatabase() {
        runBlocking {
            val context = ApplicationProvider.getApplicationContext<Context>()

            ThemeDataStore.setNightModeThemeState(true, context)

            val updatedThemeState = ThemeDataStore.getNightModeThemeState(context)

            assertTrue(updatedThemeState)
        }
    }
}