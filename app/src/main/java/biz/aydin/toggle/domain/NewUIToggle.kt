package biz.aydin.toggle.domain

class NewUIToggle(
    val getFeatureToggle: GetFeatureToggle
) {
    inline operator fun <R : Any> invoke(block: Toggle<R>.() -> Toggle<R>): R {
        return block(
            if (getFeatureToggle.invoke("NEW_GREETINGS_UI_FEATURE", false)) on() else off()
        )()
    }
}
