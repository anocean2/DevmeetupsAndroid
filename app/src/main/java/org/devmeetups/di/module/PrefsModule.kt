package org.devmeetups.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import org.devmeetups.utils.Constants
import javax.inject.Singleton

@Module
class PrefsModule {

    @Provides
    @Singleton
    fun providesSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences(Constants.SETTING, Context.MODE_PRIVATE)
    }
}