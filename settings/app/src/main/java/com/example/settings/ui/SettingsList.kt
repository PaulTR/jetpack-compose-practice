package com.example.settings.ui

import SettingsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.settings.R

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    state: SettingsState
) {
    Column(
        modifier = modifier.verticalScroll(
            rememberScrollState()
        ),
    ) {
        TopAppBar {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.cd_go_back)
            )
            Text(text = stringResource(id = R.string.title_settings))
        }
    }
}