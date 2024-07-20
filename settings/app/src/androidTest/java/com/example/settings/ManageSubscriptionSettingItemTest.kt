package com.example.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.settings.ui.ManageSubscriptionSettingItem
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ManageSubscriptionSettingItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Title_displayed() {
        val title = "Manage Subscription"
        composeTestRule.setContent {
            ManageSubscriptionSettingItem(
                title = title,
                onSettingClicked = { }
            )
        }
        composeTestRule
            .onNodeWithText(title)
            .assertIsDisplayed()
    }

    @Test
    fun On_Setting_Clicked_Triggered() {
        val title = "Manage Subscription"
        val onSettingClicked: () -> Unit = mock()
        composeTestRule.setContent {
            ManageSubscriptionSettingItem(
                title = title,
                onSettingClicked = onSettingClicked
            )
        }
        composeTestRule
            .onNodeWithText(title)
            .performClick()

        verify(onSettingClicked).invoke()
    }
}