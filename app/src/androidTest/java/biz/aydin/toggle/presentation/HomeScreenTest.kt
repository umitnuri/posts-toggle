package biz.aydin.toggle.presentation;

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun `Given NewUIToggle is removed when presenting HomeScreen then it displays NewGreetings`() {
        with(rule) {
            setContent {
                BuildHomeScreen()
            }
            onNodeWithTag("HOME_SCREEN_NEW_GREETINGS").assertIsDisplayed()
            onNodeWithTag("HOME_SCREEN_OLD_GREETINGS").assertDoesNotExist()
        }
    }
}
