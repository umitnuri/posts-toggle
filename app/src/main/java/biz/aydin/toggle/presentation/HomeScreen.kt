package biz.aydin.toggle.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import biz.aydin.toggle.domain.GetFeatureToggle
import biz.aydin.toggle.domain.NewUIToggle

@Composable
fun HomeScreen(
    viewModel: GreetingsViewModel,
    newUIToggle: NewUIToggle
) {
    HomeScreen(message = viewModel.message, newUIToggle = newUIToggle)
//    HomeScreen(message = viewModel.message)
}

/*
    // Before the toggle was applied
    @Composable
    fun HomeScreenBefore(
        modifier: Modifier = Modifier,
        message: String
    ) {
        Text(
            text = message,
            modifier = modifier,
            color = Color.Red
        )
    }

 */

@Composable
fun HomeScreen(
    message: String,
    newUIToggle: NewUIToggle
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        newUIToggle {
            on {
                NewGreeting(message = message)
            }
            off {
                OldGreeting(message = message)
            }
        }
    }
}

private val previewNewUIToggleOn = NewUIToggle { _, _ ->
    true
}

@Preview
@Composable
private fun HomeScreenPreviewNewUIToggleOn() {
    HomeScreen(message = "Message :)", newUIToggle = previewNewUIToggleOn)
}

private val previewNewUIToggleOff = NewUIToggle { _, _ -> false }

@Preview
@Composable
private fun HomeScreenPreviewNewUIToggleOff() {
    HomeScreen(message = "Message :(", newUIToggle = previewNewUIToggleOff)
}
