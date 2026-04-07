package com.example.calculatorapp.infrastructure.checkers

import com.example.calculatorapp.infrastructure.internals.checkers.isRetrievedValueEqualToNull
import net.bytebuddy.matcher.ElementMatchers.any
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class InfrastructureCheckerTest {
    @Test
    fun testIfMethodIsRetrievedValueEqualToNullReturnsTrueWhen() {
        val nullRetrievedValue = isRetrievedValueEqualToNull(null)
        val notNullRetrievedValue = isRetrievedValueEqualToNull(any<String>())

        assertTrue(nullRetrievedValue)
        assertFalse(notNullRetrievedValue)
    }
}