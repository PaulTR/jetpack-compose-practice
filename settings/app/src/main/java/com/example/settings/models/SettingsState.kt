import com.example.settings.models.MarketingOption
import com.example.settings.models.Theme

data class SettingsState(
    val notificationsEnabled: Boolean = false,
    val hintsEnabled: Boolean = false,
    val marketingOption: MarketingOption = MarketingOption.ALLOWED,
    val themeOptions: Theme = Theme.SYSTEM,
)
