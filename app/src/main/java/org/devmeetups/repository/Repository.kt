package org.devmeetups.repository

import android.util.Log
import io.reactivex.Single
import org.devmeetups.DevmeetupsApp
import org.devmeetups.model.httpapi.OkApi
import org.devmeetups.utils.Constants
import javax.inject.Inject

class Repository {

    init {
        DevmeetupsApp.getDaggerComponent().inject(this)
    }

    @Inject
    lateinit var okApi: OkApi

    fun test() {
        Log.v(Constants.LOGS_TAG, "Тест репозитория")
    }

}