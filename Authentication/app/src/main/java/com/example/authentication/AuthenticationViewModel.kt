package com.example.authentication

import androidx.lifecycle.ViewModel
import com.example.authentication.models.AuthenticationMode
import com.example.authentication.models.AuthenticationState
import com.example.authentication.models.PasswordRequirements
import kotlinx.coroutines.flow.MutableStateFlow

class AuthenticationViewModel : ViewModel() {

    val uiState = MutableStateFlow(AuthenticationState())

    private fun toggleAuthenticationMode() {
        val authenticationMode = uiState.value.authenticationMode
        val newAuthenticationMode = if (authenticationMode == AuthenticationMode.SIGN_IN) {
            AuthenticationMode.SIGN_UP
        } else {
            AuthenticationMode.SIGN_IN
        }

        uiState.value = uiState.value.copy(authenticationMode = newAuthenticationMode)
    }

    private fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(email = email)
    }

    private fun updatePassword(password: String) {
        val requirements = mutableListOf<PasswordRequirements>()
        if (password.length > 7) {
            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
        }
        if (password.any { it.isUpperCase() }) {
            requirements.add(PasswordRequirements.CAPITAL_LETTER)
        }
        if (password.any { it.isDigit() }) {
            requirements.add(PasswordRequirements.NUMBER)
        }
        uiState.value =
            uiState.value.copy(
                password = password,
                passwordRequirements = requirements.toList()
            )
    }

    fun handleEvent(authenticationEvent: AuthenticationEvent) {
        when (authenticationEvent) {
            is AuthenticationEvent.ToggleAuthenticationMode -> {
                toggleAuthenticationMode()
            }

            is AuthenticationEvent.EmailChanged -> {
                updateEmail(authenticationEvent.emailAddress)
            }

            is AuthenticationEvent.PasswordChanged -> {
                updatePassword(authenticationEvent.password)
            }
        }
    }

}