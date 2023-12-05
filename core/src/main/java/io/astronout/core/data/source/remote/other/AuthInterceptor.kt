package io.astronout.core.data.source.remote.other

import io.astronout.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url.newBuilder().addQueryParameter("key", "").build()
        return chain.proceed(originalRequest.newBuilder().url(url).build())
    }
}