package io.astronout.core.data.source.remote.other

import io.astronout.core.BuildConfig
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("Authorization", "Bearer ${BuildConfig.GITHUB_TOKEN}")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}