package com.example.calculatorapp.infrastructure.exceptions

import com.example.calculatorapp.constants.InfrastructureConstants

class NotExistingKeyException(key: String) : Exception(
    InfrastructureConstants.NOT_EXISTING_KEY_EXCEPTION_MESSAGE(
        key
    )
)
