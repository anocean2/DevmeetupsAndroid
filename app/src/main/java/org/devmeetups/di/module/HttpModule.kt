package org.devmeetups.di.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.devmeetups.model.httpapi.OkApi
import javax.inject.Singleton

@Module
class HttpModule {

    @Provides
    @Singleton
    fun providesOkHttp(): OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesOkApi(): OkApi {
        return OkApi()
    }
}