package com.example.authentication.models

import androidx.annotation.StringRes
import com.example.authentication.R

enum class PasswordRequirements {
    CAPITAL_LETTER, NUMBER, EIGHT_CHARACTERS
}

enum class PasswordRequirement(
    @StringRes val label: Int
) {
    CAPITAL_LETTER(R.string.password_requirement_capital),
    NUMBER(R.string.password_requirement_digit),
    EIGHT_CHARACTERS(R.string.password_requirement_characters)
}

enum class AuthenticationMode {
    SIGN_UP, SIGN_IN
}