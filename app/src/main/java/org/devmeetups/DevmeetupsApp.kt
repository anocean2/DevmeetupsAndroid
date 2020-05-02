package org.devmeetups

import android.app.Application
import android.util.Log
import org.devmeetups.di.component.DaggerComponent
import org.devmeetups.di.component.DaggerDaggerComponent
import org.devmeetups.di.module.AppModule
import org.devmeetups.di.module.PrefsModule
import org.devmeetups.utils.Constants

class DevmeetupsApp : Application() {

    companion object {
        private lateinit var mDaggerComponent: DaggerComponent

        fun getDaggerComponent(): DaggerComponent {
            return mDaggerComponent
        }
    }

    override fun onCreate() {
        super.onCreate()

        Log.d(Constants.LOGS_TAG, "onCreate: DevmeetupsApp")

        mDaggerComponent = DaggerDaggerComponent.builder()
                .appModule(AppModule(this))
                .prefsModule(PrefsModule())
                .build()
    }


}