package com.example.calculatorapp.user_interface.internals.enums

import com.example.calculatorapp.domains.calculator.Characters

enum class CalculatorCharacters(val value: String) {
    ZERO(Characters.ZERO.value),

    ONE(Characters.ONE.value),

    TWO(Characters.TWO.value),

    THREE(Characters.THREE.value),

    FOUR(Characters.FOUR.value),

    FIVE(Characters.FIVE.value),

    SIX(Characters.SIX.value),

    SEVEN(Characters.SEVEN.value),

    EIGHT(Characters.EIGHT.value),

    NINE(Characters.NINE.value),

    ADDITION(Characters.ADDITION.value),

    SUBTRACTION(Characters.SUBTRACTION.value),

    DIVISION(Characters.DIVISION.value),

    MULTIPLICATION(Characters.MULTIPLICATION.value),

    POINT(Characters.POINT.value),

    CLEAN("C"),

    EVALUATION("="),

    BACKSPACE("<")
}