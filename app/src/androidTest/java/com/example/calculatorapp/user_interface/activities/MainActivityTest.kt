package com.example.calculatorapp.user_interface.activities

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import com.example.calculatorapp.R
import com.example.calculatorapp.constants.ApplicationConstants
import com.example.calculatorapp.user_interface.internals.enums.CalculatorCharacters
import junit.framework.TestCase.assertNotNull
import org.junit.AfterClass
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun beforeEach() {
        device.pressHome()
        val appName = context.getString(R.string.app_name)
        val appIconElement = device.findObject(By.text(appName))

        appIconElement.click()

        device.wait(
            Until.hasObject(By.text(CalculatorCharacters.CLEAN.value)),
            ApplicationConstants.LAUNCH_TIMEOUT
        )
    }

    @Test
    fun testIfActivityIsSet() {
        val oneButtonElement =
            device.findObject(By.text(CalculatorCharacters.ONE.value))

        assertNotNull(oneButtonElement)
    }

    companion object {
        private val instrumentation = InstrumentationRegistry.getInstrumentation()
        private val device = UiDevice.getInstance(instrumentation)

        @AfterClass
        @JvmStatic
        fun afterAll() {
            device.pressHome()
        }
    }
}