package org.devmeetups.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.disposables.CompositeDisposable
import org.json.JSONArray
import org.json.JSONObject
import org.devmeetups.DevmeetupsApp
import org.devmeetups.repository.Repository
import org.devmeetups.utils.Constants
import javax.inject.Inject

class MainViewModel : ViewModel() {

    private val disposibles: CompositeDisposable

    init {
        DevmeetupsApp.getDaggerComponent().inject(this)
        disposibles = CompositeDisposable()
    }

    @Inject
    lateinit var repo: Repository

    @Inject
    lateinit var gson: Gson


    override fun onCleared() {
        super.onCleared()

        if (disposibles.size() != 0) {
            disposibles.dispose()
        }
    }
}