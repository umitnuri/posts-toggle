package biz.aydin.toggle.domain

class NewGreetingServiceToggle(
    val featureToggle: FeatureToggle
) {
    inline operator fun <R : Any> invoke(block: Toggle<R>.() -> Toggle<R>): R {
        return block(
            if (featureToggle.getToggle("NEW_GREETING_SERVICE", false)) on() else off()
        )()
    }
}
