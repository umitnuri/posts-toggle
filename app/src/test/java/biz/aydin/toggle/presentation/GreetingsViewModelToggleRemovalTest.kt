package biz.aydin.toggle.presentation

import assertk.assertThat
import assertk.assertions.isEqualTo
import biz.aydin.toggle.domain.FeatureToggle
import biz.aydin.toggle.domain.GetNewGreetingUseCase
import biz.aydin.toggle.domain.GetOldGreetingUseCase
import biz.aydin.toggle.domain.NewDomainToggle
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class GreetingsViewModelToggleRemovalTest {
    private lateinit var viewModel: GreetingsViewModel
    private val getOldGreeting: GetOldGreetingUseCase = mockk()
    private val getNewGreeting: GetNewGreetingUseCase = mockk()
    private val featureToggle: FeatureToggle = mockk()

    @Before
    fun before() {
        viewModel = GreetingsViewModel(
            getOldGreeting = getOldGreeting,
            getNewGreeting = getNewGreeting,
            newDomainToggle = NewDomainToggle(featureToggle = featureToggle)
        )
        every { featureToggle.getToggle("NEW_GREETING_MESSAGE", any()) } returns true
    }

    @Test
    fun `Given NewMessageToggle is removed, when getting the message, then it executes GetNewGreetingUseCase`() {
        every { getNewGreeting() } returns "MESSAGE"

        assertThat(viewModel.message).isEqualTo("MESSAGE")

        verify(exactly = 1) {
            getNewGreeting()
        }
    }
}
