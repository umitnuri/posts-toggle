package biz.aydin.toggle.domain

class NewGreetingServiceToggle(
    val getFeatureToggle: GetFeatureToggle
) {
    inline operator fun <R : Any> invoke(block: Toggle<R>.() -> Toggle<R>): R {
        return block(
            if (getFeatureToggle.invoke("NEW_GREETING_SERVICE", false)) on() else off()
        )()
    }
}
