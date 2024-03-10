package biz.aydin.toggle.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import biz.aydin.toggle.presentation.theme.ToggleTheme

@Composable
fun OldGreeting(
    modifier: Modifier = Modifier,
    message: String
) {
    Text(
        text = message,
        modifier = modifier.then(Modifier.testTag("HOME_SCREEN_OLD_GREETINGS")),
        color = Color.Red
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToggleTheme {
        OldGreeting(message = "Old UI")
    }
}
