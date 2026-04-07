package com.example.calculatorapp.user_interface.internals.stores

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class UserInterfaceThemeStoreTest {
    @Before
    fun beforeEach() {
        stopKoin()
    }

    @Test
    fun testIfClassHandleThemeStoringOnKeyValueDatabase() {
        runBlocking {
            val context = ApplicationProvider.getApplicationContext<Context>()

            UserInterfaceThemeStore.setNightModeThemeState(true, context)

            val updatedThemeState = UserInterfaceThemeStore.getNightModeThemeState(context)

            Assert.assertTrue(updatedThemeState)
        }
    }
}