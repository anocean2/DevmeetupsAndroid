package org.devmeetups.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import org.devmeetups.model.AppDatabase
import javax.inject.Singleton


@Module
class DataBaseModule {

  /*  @Singleton
    @Provides
    fun provideDataBase(app: Application): AppDatabase {
        return Room.databaseBuilder(app.getApplicationContext(), AppDatabase::class.java, "devmeetups")
                .fallbackToDestructiveMigration()
                .build()
    }
*/
   /* @Singleton
    @Provides
    fun provideTokenDao(db: AppDatabase): TokenDao {
        return db.getTokenDao()
    }*/
}