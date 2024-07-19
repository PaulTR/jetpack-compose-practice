package com.example.settings.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.settings.R
import com.example.settings.SettingsViewModel

@Composable
fun Settings() {

    val viewModel: SettingsViewModel = viewModel()

    MaterialTheme {
        val state = viewModel.uiState.collectAsState().value
        SettingsList(modifier = Modifier.fillMaxSize(),
            state = state,
            toggleNotificationSetting = viewModel::toggleNotificationSettings)
    }
}

