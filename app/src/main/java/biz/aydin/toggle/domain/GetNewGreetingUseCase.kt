package biz.aydin.toggle.domain

class GetNewGreetingUseCase(
    private val greetings: Greetings
) {
    operator fun invoke(): String {
        return "NEW USE CASE MESSAGE " + greetings.getGreetingMessage()
    }
}
