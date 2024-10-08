package com.example.authentication.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.authentication.R

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    email: String?,
    onEmailChanged: (email: String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = email ?: "",
        onValueChange = { email ->
            onEmailChanged(email)
        },
        label = {
            Text(text = stringResource(id = R.string.label_email))
        },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )
        }
    )
}