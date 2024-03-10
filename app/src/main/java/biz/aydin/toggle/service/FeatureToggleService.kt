package biz.aydin.toggle.service

import biz.aydin.toggle.domain.FeatureToggle

class FeatureToggleService : FeatureToggle {
    override fun getToggle(key: String, default: Boolean): Boolean {
        return default
    }
}
