package com.example.calculatorapp.constants

class InfrastructureConstants {
    companion object {
        fun NOT_EXISTING_KEY_EXCEPTION_MESSAGE(key: String): String {
            return "Key: \"$key\"; Does Not Exist!"
        }
    }
}