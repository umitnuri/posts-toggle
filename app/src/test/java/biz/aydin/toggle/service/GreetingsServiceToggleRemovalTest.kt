package biz.aydin.toggle.service


import assertk.assertThat
import assertk.assertions.isEqualTo
import biz.aydin.toggle.domain.FeatureToggle
import biz.aydin.toggle.domain.NewServiceToggle
import org.junit.Test


class GreetingsServiceToggleRemovalTest {
    private val greetingsService: GreetingsService = GreetingsService(
        newServiceToggle = NewServiceToggle(
            object : FeatureToggle {
                override fun getToggle(key: String, default: Boolean): Boolean {
                    return true
                }
            }
        )
    )

    @Test
    fun `Given NewServiceToggle is remove, when getting message, then it returns new message`() {
        assertThat(greetingsService.getGreetingMessage()).isEqualTo("NEW GET SERVICE MESSAGE")
    }
}
