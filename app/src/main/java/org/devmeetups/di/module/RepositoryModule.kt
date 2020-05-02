package org.devmeetups.di.module

import dagger.Module
import dagger.Provides
import org.devmeetups.repository.Repository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesRepository(): Repository {
        return Repository()
    }
}