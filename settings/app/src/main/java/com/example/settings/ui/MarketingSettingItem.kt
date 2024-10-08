package com.example.settings.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.example.settings.R
import com.example.settings.models.MarketingOption
import com.example.settings.models.Tags.TAG_MARKETING_OPTION

@Composable
fun MarketingSettingItem(
    modifier: Modifier = Modifier,
    selectedOption: MarketingOption,
    onOptionSelected: (option: MarketingOption) -> Unit
) {
    val options = stringArrayResource(id = R.array.setting_options_marketing_choice)
    SettingItem(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.setting_option_marketing))
            Spacer(modifier = Modifier.height(8.dp))
            options.forEachIndexed { index, option ->
                Row(
                    modifier = Modifier
                        .testTag(TAG_MARKETING_OPTION + index)
                        .selectable(
                            selected = selectedOption.id == index,
                            onClick = {
                                val marketingOption = if (index == MarketingOption.ALLOWED.id) {
                                    MarketingOption.ALLOWED
                                } else MarketingOption.NOT_ALLOWED

                                onOptionSelected(marketingOption)
                            },
                            role = Role.RadioButton
                        )
                        .fillMaxWidth()
                        .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedOption.id == index,
                        onClick = null
                    )
                    Text(modifier = Modifier.padding(start = 18.dp), text = option)
                }
            }
        }
    }
}