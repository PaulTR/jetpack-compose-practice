package com.example.authentication.models

data class AuthenticationState(
    val email: String? = null,
    val password: String? = null,
    val passwordRequirements: List<PasswordRequirements> = emptyList(),
    val authenticationMode: AuthenticationMode = AuthenticationMode.SIGN_IN,
    val isLoading: Boolean = false,
    val error: String? = null
) {
    fun isFormValid(): Boolean {
        return password?.isNotEmpty()!! &&
                email?.isNotEmpty()!! &&
                (authenticationMode == AuthenticationMode.SIGN_IN
                        || passwordRequirements.containsAll(PasswordRequirements.values().toList()))
    }
}