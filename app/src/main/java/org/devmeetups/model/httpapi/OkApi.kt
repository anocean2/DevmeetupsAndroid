package org.devmeetups.model.httpapi

import io.reactivex.Single
import com.google.gson.Gson
import javax.inject.Inject
import okhttp3.OkHttpClient
import android.content.SharedPreferences
import org.devmeetups.DevmeetupsApp

class OkApi {

    init {
        DevmeetupsApp.getDaggerComponent().inject(this)
    }

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var client: OkHttpClient

    @Inject
    lateinit var gson: Gson

}