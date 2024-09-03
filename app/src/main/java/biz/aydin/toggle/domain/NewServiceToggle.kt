package biz.aydin.toggle.domain

class NewServiceToggle(
    val getFeatureToggle: GetFeatureToggle
) {
    inline operator fun <R : Any> invoke(block: Toggle<R>.() -> Toggle<R>): R {
        return block(if (getFeatureToggle.invoke("NEW_SERVICE_KEY", true)) on() else off())()
    }
}
