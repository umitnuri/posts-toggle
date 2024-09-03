@file:Suppress("TestFunctionName")

package biz.aydin.toggle.presentation

import androidx.compose.runtime.Composable
import biz.aydin.toggle.domain.GetFeatureToggle
import biz.aydin.toggle.domain.NewUIToggle

fun buildRemovedStateToggle(): NewUIToggle = NewUIToggle { _, _ -> true }


@Composable
fun BuildHomeScreen(
    newUIToggle: NewUIToggle = buildRemovedStateToggle(),
) {
    HomeScreen(
        message = "Message",
        newUIToggle = newUIToggle
    )
}
