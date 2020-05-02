package org.devmeetups.di.component

import dagger.Component
import org.devmeetups.di.module.*
import org.devmeetups.model.adapters.AdapterCataloge
import org.devmeetups.model.httpapi.OkApi
import org.devmeetups.repository.Repository
import org.devmeetups.ui.main.MainViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    PrefsModule::class,
    RepositoryModule::class,
    HttpModule::class,
    UtilsModule::class,
    DataBaseModule::class])

interface DaggerComponent {
    fun inject(mainViewModel: MainViewModel)
    fun inject(repository: Repository)
    fun inject(okApi: OkApi)
    fun inject(adapterCataloge: AdapterCataloge)
}