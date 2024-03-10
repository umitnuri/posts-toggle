package biz.aydin.toggle.presentation

import android.content.res.Configuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import biz.aydin.toggle.presentation.theme.ToggleTheme


@Composable
fun NewGreeting(
    modifier: Modifier = Modifier,
    message: String
) {
    Text(
        text = message,
        modifier = modifier.then(Modifier.testTag("HOME_SCREEN_NEW_GREETINGS")),
        color = Color.Green
    )
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.NONE
)
@Composable
fun NewGreetingPreview() {
    ToggleTheme {
        NewGreeting(message = "New UI")
    }
}
