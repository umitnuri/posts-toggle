package biz.aydin.toggle.presentation

import biz.aydin.toggle.domain.GetNewGreetingUseCase
import biz.aydin.toggle.domain.GetOldGreetingUseCase
import biz.aydin.toggle.domain.NewDomainToggle

class GreetingsViewModel(
    private val getOldGreeting: GetOldGreetingUseCase,
    private val getNewGreeting: GetNewGreetingUseCase,
    private val newDomainToggle: NewDomainToggle
) {
    val message: String
        get() = newDomainToggle {
            on {
                getNewGreeting()
            }
            off {
                getOldGreeting()
            }
        }
}

/*
    // Before the toggle was applied
    class GreetingsViewModel(
        private val getGreeting: GetGreetingUseCase
    ) {
        val message: String
            get() = getGreeting()
    }
 */