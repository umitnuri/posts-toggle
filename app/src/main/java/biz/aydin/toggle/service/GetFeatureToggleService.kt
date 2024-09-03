package biz.aydin.toggle.service

import biz.aydin.toggle.domain.GetFeatureToggle

class GetFeatureToggleService : GetFeatureToggle {
    override operator fun invoke(key: String, default: Boolean): Boolean {
        return default
    }
}
