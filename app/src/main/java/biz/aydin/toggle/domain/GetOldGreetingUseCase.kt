package biz.aydin.toggle.domain

class GetOldGreetingUseCase(
    private val greetings: Greetings
) {
    operator fun invoke(): String {
        return "OLD USE CASE MESSAGE " + greetings.getGreetingMessage()
    }
}
