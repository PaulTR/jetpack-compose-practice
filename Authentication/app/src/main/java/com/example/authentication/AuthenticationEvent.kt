package com.example.authentication

sealed class AuthenticationEvent {

    object ToggleAuthenticationMode: AuthenticationEvent()

    object Authenticate: AuthenticationEvent()
    object ErrorDismissed: AuthenticationEvent()

    class EmailChanged(val emailAddress: String) :
            AuthenticationEvent()

    class PasswordChanged(val password: String):
            AuthenticationEvent()

}