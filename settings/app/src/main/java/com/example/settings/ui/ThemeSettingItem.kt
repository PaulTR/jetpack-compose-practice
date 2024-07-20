package com.example.settings.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.settings.R
import com.example.settings.models.Tags.TAG_SELECT_THEME
import com.example.settings.models.Tags.TAG_THEME
import com.example.settings.models.Tags.TAG_THEME_OPTION
import com.example.settings.models.Theme

@Composable
fun ThemeSettingItem(
    modifier: Modifier = Modifier,
    selectedTheme: Theme,
    onOptionsSelected: (option: Theme) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier
                .clickable(
                    onClick = { expanded = !expanded },
                    onClickLabel = stringResource(id = R.string.cd_select_theme)
                )
                .padding(16.dp)
                .testTag(TAG_SELECT_THEME),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.setting_option_theme)
            )
            Text(
                modifier = Modifier.testTag(TAG_THEME),
                text = stringResource(id = selectedTheme.label))
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(16.dp, 0.dp)
        ) {
            Theme.values().forEach { theme ->
                DropdownMenuItem(onClick = {
                    onOptionsSelected(theme)
                    expanded = false
                }, modifier = Modifier.testTag(TAG_THEME_OPTION + theme.label)) {
                    Text(text = stringResource(id = theme.label))
                }
            }
        }
    }
}