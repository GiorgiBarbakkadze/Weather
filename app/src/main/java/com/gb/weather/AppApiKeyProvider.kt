package com.gb.weather

import com.gb.domain.common.ApiKeyProvider

class AppApiKeyProvider: ApiKeyProvider {
    override fun getApiKey(): String = BuildConfig.API_KEY
}