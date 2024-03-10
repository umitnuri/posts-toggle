package biz.aydin.toggle.service

import biz.aydin.toggle.domain.Greetings
import biz.aydin.toggle.domain.NewServiceToggle

class GreetingsService(
    private val newServiceToggle: NewServiceToggle
) : Greetings {
    override fun getGreetingMessage(): String {
        return newServiceToggle {
            on {
                newGet()
            }
            off {
                oldGet()
            }
        }
    }

    private fun oldGet(): String {
        return "OLD GET SERVICE MESSAGE"
    }

    private fun newGet(): String {
        return "NEW GET SERVICE MESSAGE"
    }
}

/*
    // Before toggle was applied
    class GreetingsService: Greetings {
        override fun getGreetingMessage(): String {
            return "NEW GET SERVICE MESSAGE"
        }
    }
 */