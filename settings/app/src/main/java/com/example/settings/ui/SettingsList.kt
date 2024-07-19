package com.example.settings.ui

import SettingsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.settings.R

@Composable
fun SettingsList(
    modifier: Modifier = Modifier, state: SettingsState,
    toggleNotificationSetting: () -> Unit,
) {
    Column(
        modifier = modifier.verticalScroll(
            rememberScrollState()
        ),
    ) {
        SettingsTopAppBar(state = state, modifier = modifier)
        Spacer(modifier = Modifier.height(8.dp))
        NotificationSettings(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.setting_enable_notifications),
            checked = state.notificationsEnabled,
            onCheckedChanged = { toggleNotificationSetting() }
        )
        Divider()
    }
}