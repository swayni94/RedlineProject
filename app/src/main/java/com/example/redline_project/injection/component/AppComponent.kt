package com.example.redline_project.injection.component

import android.content.Context
import com.example.redline_project.MainActivity
import com.example.redline_project.data_source.local.AppDao
import com.example.redline_project.data_source.local.AppDb
import com.example.redline_project.fragment.DetailScreenFragment
import com.example.redline_project.fragment.DisplayScrenFragment
import com.example.redline_project.fragment.FirstFragment
import com.example.redline_project.fragment.MainFragment
import com.example.redline_project.injection.modules.*
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CoroutinesModule::class,
    RepositoryModule::class,
   // StorageModule::class,
    NetworkModule::class
])
interface AppComponent {
    fun context(): Context

    fun retrofit(): Retrofit

   // fun appDao(): AppDao

   // fun appDatabase(): AppDb


    fun inject(mainActivity: MainActivity)
    fun inject(firstFragment: FirstFragment)
    fun inject(mainFragment: MainFragment)
    fun inject(displayScrenFragment: DisplayScrenFragment)
    fun inject(detailScreenFragment: DetailScreenFragment)
}