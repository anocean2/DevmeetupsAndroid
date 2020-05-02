package org.devmeetups.model

import androidx.room.RoomDatabase
import androidx.room.Database


//@Database(entities = [], version = 3)
abstract class AppDatabase : RoomDatabase() {
   // abstract fun getTokenDao(): TokenDao
}