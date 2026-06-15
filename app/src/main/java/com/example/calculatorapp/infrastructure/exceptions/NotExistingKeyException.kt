package com.example.calculatorapp.infrastructure.exceptions

import com.example.calculatorapp.constants.infrastructure.KeyValueDatabaseConstants

class NotExistingKeyException(key: String) : Exception(
    KeyValueDatabaseConstants.NOT_EXISTING_KEY_EXCEPTION_MESSAGE(
        key
    )
)
