package com.example.calculatorapp.user_interface.internals.checkers

import com.example.calculatorapp.constants.LARGER_SCREEN_WIDTH
import com.example.calculatorapp.constants.SMALLER_SCREEN_WIDTH
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class UserInterfaceCheckerTest {
    @Test
    fun testIfMethodIsScreenHeightSmallReturnsTrueWhenDeviceScreenIsSmaller() {
        val userInterfaceIsSmall = isScreenHeightSmall(SMALLER_SCREEN_WIDTH)
        val userInterfaceIsLarge = isScreenHeightSmall(LARGER_SCREEN_WIDTH)

        assertTrue(userInterfaceIsSmall)
        assertFalse(userInterfaceIsLarge)
    }
}