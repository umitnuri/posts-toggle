package biz.aydin.toggle.domain

class NewDomainToggle(
    val featureToggle: FeatureToggle
) {
    inline operator fun <R : Any> invoke(block: Toggle<R>.() -> Toggle<R>): R {
        return block(
            if (featureToggle.getToggle("NEW_GREETING_MESSAGE", false)) on() else off()
        )()
    }
}
