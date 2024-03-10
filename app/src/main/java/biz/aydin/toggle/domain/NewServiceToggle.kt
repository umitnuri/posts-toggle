package biz.aydin.toggle.domain

class NewServiceToggle(
    val featureToggle: FeatureToggle
) {
    inline operator fun <R : Any> invoke(block: Toggle<R>.() -> Toggle<R>): R {
        return block(if (featureToggle.getToggle("NEW_SERVICE_KEY", true)) on() else off())()
    }
}
