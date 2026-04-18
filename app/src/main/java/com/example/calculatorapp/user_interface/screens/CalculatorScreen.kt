package com.example.calculatorapp.user_interface.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.R
import com.example.calculatorapp.user_interface.components.action_bar.ActionBar
import com.example.calculatorapp.user_interface.components.button.Button
import com.example.calculatorapp.user_interface.components.keyboard.Keyboard
import com.example.calculatorapp.user_interface.components.viewfinder.Viewfinder
import com.example.calculatorapp.constants.VIEWFINDER_VALUE_WIDTH
import com.example.calculatorapp.domains.calculator.Characters
import com.example.calculatorapp.user_interface.theme.Theme
import com.example.calculatorapp.user_interface.internals.enums.CalculatorCharacters
import com.example.calculatorapp.user_interface.view_models.CalculatorViewModel
import com.example.calculatorapp.user_interface.view_models.ThemeModeViewModel

@Composable
fun CalculatorScreen(
    calculatorViewModel: CalculatorViewModel,
    themeModeViewModel: ThemeModeViewModel
) {
    val context = LocalContext.current
    val viewFinderScrollState = ScrollState(
        VIEWFINDER_VALUE_WIDTH(calculatorViewModel.expression.value.length)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.appBackgroundColor)
    ) {
        ActionBar(
            actionIconDrawableResourceId =
                if (themeModeViewModel.themeMode.value) R.drawable.moon_waning_crescent
                    else R.drawable.white_balance_sunny,
            actionContentDescriptionStringResourceId = R.string.actionbar_menu_toggle_night_mode_content_description,
        ) {
            themeModeViewModel.toggleTheme(context)
        }
        Viewfinder(calculatorViewModel.expression.value, viewFinderScrollState)
        Keyboard {
            Row(
                modifier = Modifier
                    .weight(weight = 1f, fill = true)
                    .padding(bottom = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = CalculatorCharacters.CLEAN,
                        backgroundColor = Theme.colors.yellowButtonBackgroundColor,
                        characterColor = Theme.colors.yellowButtonCharacterColor,
                        borderColor = Theme.colors.yellowButtonBorderColor,
                    ) {
                        calculatorViewModel.clean(context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = CalculatorCharacters.DIVISION,
                        backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(Characters.DIVISION, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = CalculatorCharacters.MULTIPLICATION,
                        backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(
                            Characters.MULTIPLICATION,
                            context
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                ) {
                    Button(
                        character = CalculatorCharacters.BACKSPACE,
                        backgroundColor = Theme.colors.yellowButtonBackgroundColor,
                        characterColor = Theme.colors.yellowButtonCharacterColor,
                        borderColor = Theme.colors.yellowButtonBorderColor,
                    ) {
                        calculatorViewModel.backspace(context)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .weight(weight = 1f, fill = true)
                    .padding(bottom = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = CalculatorCharacters.SEVEN,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(Characters.SEVEN, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = CalculatorCharacters.EIGHT,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(Characters.EIGHT, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = CalculatorCharacters.NINE,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(Characters.NINE, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                ) {
                    Button(
                        character = CalculatorCharacters.SUBTRACTION,
                        backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(Characters.SUBTRACTION, context)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .weight(weight = 1f, fill = true)
                    .padding(bottom = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = CalculatorCharacters.FOUR,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(Characters.FOUR, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = CalculatorCharacters.FIVE,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(Characters.FIVE, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = CalculatorCharacters.SIX,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(Characters.SIX, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                ) {
                    Button(
                        character = CalculatorCharacters.ADDITION,
                        backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(Characters.ADDITION, context)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .weight(weight = 2f, fill = true)
                    .padding(bottom = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .weight(weight = 3f, fill = true)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(weight = 1f, fill = true)
                            .padding(bottom = 8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(weight = 1f, fill = true)
                                .padding(end = 8.dp)
                        ) {
                            Button(
                                character = CalculatorCharacters.ONE,
                                backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.primaryBlueButtonBorderColor,
                            ) {
                                calculatorViewModel.addCharacter(Characters.ONE, context)
                            }
                        }
                        Box(
                            modifier = Modifier
                                .weight(weight = 1f, fill = true)
                                .padding(end = 8.dp)
                        ) {
                            Button(
                                character = CalculatorCharacters.TWO,
                                backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.primaryBlueButtonBorderColor,
                            ) {
                                calculatorViewModel.addCharacter(Characters.TWO, context)
                            }
                        }
                        Box(
                            modifier = Modifier
                                .weight(weight = 1f, fill = true)
                        ) {
                            Button(
                                character = CalculatorCharacters.THREE,
                                backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.primaryBlueButtonBorderColor,
                            ) {
                                calculatorViewModel.addCharacter(
                                    Characters.THREE,
                                    context
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(weight = 1f, fill = true)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(weight = 2f, fill = true)
                                .padding(end = 8.dp)
                        ) {
                            Button(
                                character = CalculatorCharacters.ZERO,
                                backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.primaryBlueButtonBorderColor,
                            ) {
                                calculatorViewModel.addCharacter(Characters.ZERO, context)
                            }
                        }
                        Box(
                            modifier = Modifier
                                .weight(weight = 1f, fill = true)
                        ) {
                            Button(
                                character = CalculatorCharacters.POINT,
                                backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                            ) {
                                calculatorViewModel.addCharacter(
                                    Characters.POINT,
                                    context
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                ) {
                    Button(
                        character = CalculatorCharacters.EVALUATION,
                        backgroundColor = Theme.colors.yellowButtonBackgroundColor,
                        characterColor = Theme.colors.yellowButtonCharacterColor,
                        borderColor = Theme.colors.yellowButtonBorderColor,
                    ) {
                        calculatorViewModel.evaluate(context)
                    }
                }
            }
        }
    }
}
