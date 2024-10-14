package com.example.authentication.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authentication.AuthenticationViewModel
import com.example.authentication.models.AuthenticationMode

@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    email: String?,
    password: String?,
    onEmailChanged: (email: String) -> Unit,
    onPasswordChanged: (password: String) -> Unit,
    onAuthenticate: () -> Unit
) {

    val passwordFocusRequester = FocusRequester()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        AuthenticationTitle(
            modifier = Modifier.fillMaxWidth(),
            authenticationMode = authenticationMode
        )
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
                elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EmailInput(
                    modifier = Modifier.fillMaxWidth(),
                    email = email ?: "",
                    onEmailChanged = onEmailChanged
                ) {
                    passwordFocusRequester.requestFocus()
                }
                Spacer(modifier = Modifier.height(16.dp))
                PasswordInput(
                    modifier = Modifier.fillMaxWidth().focusRequester(passwordFocusRequester),
                    password = password ?: "",
                    onPasswordChanged = onPasswordChanged,
                    onDoneClicked = onAuthenticate
                )
            }

        }
    }
}