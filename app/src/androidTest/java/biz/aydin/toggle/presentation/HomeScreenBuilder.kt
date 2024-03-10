@file:Suppress("TestFunctionName")

package biz.aydin.toggle.presentation

import androidx.compose.runtime.Composable
import biz.aydin.toggle.domain.FeatureToggle
import biz.aydin.toggle.domain.NewUIToggle

fun buildRemovedStateToggle(): NewUIToggle = NewUIToggle(
    object : FeatureToggle {
        override fun getToggle(key: String, default: Boolean): Boolean {
            return true
        }
    }
)


@Composable
fun BuildHomeScreen(
    newUIToggle: NewUIToggle = buildRemovedStateToggle(),
) {
    HomeScreen(
        message = "Message",
        newUIToggle = newUIToggle
    )
}
