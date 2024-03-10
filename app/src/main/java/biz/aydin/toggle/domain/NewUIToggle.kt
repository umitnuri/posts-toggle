package biz.aydin.toggle.domain

class NewUIToggle(
    val featureToggle: FeatureToggle
) {
    inline operator fun <R : Any> invoke(block: Toggle<R>.() -> Toggle<R>): R {
        return block(
            if (featureToggle.getToggle("NEW_GREETINGS_UI_FEATURE", false)) on() else off()
        )()
    }
}
