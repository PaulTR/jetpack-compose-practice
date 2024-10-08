package com.example.settings

import SettingsState
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.settings.models.MarketingOption
import com.example.settings.models.Theme
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsViewModel : ViewModel() {
    val uiState = MutableStateFlow(SettingsState())

    fun toggleNotificationSettings() {
        uiState.value = uiState.value.copy(notificationsEnabled = !uiState.value.notificationsEnabled)
    }

    fun toggleHintSettings() {
        uiState.value = uiState.value.copy(hintsEnabled = !uiState.value.hintsEnabled)
    }

    fun onManageSubscription() {
        Log.e("Test", "on manage subscription")
    }

    fun setMarketingSettings(option: MarketingOption) {
        uiState.value = uiState.value.copy(marketingOption = option)
    }

    fun setTheme(theme: Theme) {
        uiState.value = uiState.value.copy(themeOptions = theme)
    }

}