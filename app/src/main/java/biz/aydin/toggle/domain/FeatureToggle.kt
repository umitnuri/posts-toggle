package biz.aydin.toggle.domain

interface FeatureToggle {
    fun getToggle(key: String, default: Boolean): Boolean
}
