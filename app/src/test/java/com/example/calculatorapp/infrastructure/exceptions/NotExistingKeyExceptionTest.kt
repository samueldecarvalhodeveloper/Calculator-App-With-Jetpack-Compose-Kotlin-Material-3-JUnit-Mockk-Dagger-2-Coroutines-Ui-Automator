package com.example.calculatorapp.infrastructure.exceptions

import com.example.calculatorapp.constants.InfrastructureConstants.Companion.NOT_EXISTING_KEY_EXCEPTION_MESSAGE
import com.example.calculatorapp.constants.LAST_SESSION_EXPRESSION_KEY
import org.junit.Assert.assertEquals
import org.junit.Test

class NotExistingKeyExceptionTest {
    @Test
    fun testIfClassDeclaresHowNotExistingKeyExceptionShouldBeThrown() {
        try {
            throw NotExistingKeyException(LAST_SESSION_EXPRESSION_KEY)
        } catch (exception: Exception) {
            val exceptionMessage = exception.message

            assertEquals(
                NOT_EXISTING_KEY_EXCEPTION_MESSAGE(
                    LAST_SESSION_EXPRESSION_KEY
                ),
                exceptionMessage
            )
        }
    }
}