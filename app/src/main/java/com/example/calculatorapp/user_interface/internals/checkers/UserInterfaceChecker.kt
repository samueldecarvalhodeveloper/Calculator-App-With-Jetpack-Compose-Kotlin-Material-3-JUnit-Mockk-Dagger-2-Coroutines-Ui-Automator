package com.example.calculatorapp.user_interface.internals.checkers

import androidx.compose.ui.unit.Dp
import com.example.calculatorapp.constants.SMALL_SCREEN_HEIGHT

fun isScreenHeightSmall(currentScreenHeight: Dp): Boolean {
    return currentScreenHeight < SMALL_SCREEN_HEIGHT
}