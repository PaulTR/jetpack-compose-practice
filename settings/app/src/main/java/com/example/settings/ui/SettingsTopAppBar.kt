package com.example.settings.ui

import SettingsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.settings.R

@Composable
fun SettingsTopAppBar(
    modifier: Modifier = Modifier,
    state: SettingsState
) {
    TopAppBar(backgroundColor = MaterialTheme.colors.surface,
    contentPadding = PaddingValues(start = 12.dp)
    ) {
        Icon(
            tint = MaterialTheme.colors.onSurface,
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.cd_go_back),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = stringResource(id = R.string.title_settings),
            color = MaterialTheme.colors.onSurface,
            fontSize = 18.sp,
        )
    }
}