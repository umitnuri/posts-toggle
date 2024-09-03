package biz.aydin.toggle.domain

fun interface GetFeatureToggle {
    operator fun invoke(key: String, default: Boolean): Boolean
}
