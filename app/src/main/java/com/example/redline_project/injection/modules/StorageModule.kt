package com.example.redline_project.injection.modules

import android.app.Application
import androidx.room.Room
import com.example.redline_project.data_source.local.AppDao
import com.example.redline_project.data_source.local.AppDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule (private val application: Application){

    private val appDb: AppDb = Room.databaseBuilder(application.applicationContext, AppDb::class.java, "dog_database").build()



    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDb {
        //AppDb.getDatabase(application)
       // val appDb: AppDb = Room.databaseBuilder(application, AppDb::class.java, "db_app").build()
        return appDb
      //  return Room.databaseBuilder(application, AppDb::class.java, "db_app").build()
    }

    @Singleton
    @Provides
    fun providesAppDao(demoDatabase: AppDb): AppDao {
        return demoDatabase.appDao()
    }
}