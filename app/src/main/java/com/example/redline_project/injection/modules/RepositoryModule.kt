package com.example.redline_project.injection.modules

import com.example.redline_project.api.ApiService
import com.example.redline_project.data_source.local.AppDao
import com.example.redline_project.data_source.remote.RemoteDataSourceImpl
import com.example.redline_project.injection.IoDispatcher
import com.example.redline_project.repository.AppRepository
import com.example.redline_project.repository2.ApiServiceRxjava
import com.example.redline_project.repository2.RepositoryRxjava
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideIAppRepository(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        api: ApiService,
     //   appDao: AppDao
    ):AppRepository{
        val userDataSource = RemoteDataSourceImpl(api, ioDispatcher)
       // return AppRepository(userDataSource, appDao, ioDispatcher)
        return AppRepository(userDataSource, ioDispatcher)
    }

    @Provides
    @Singleton
    fun provideRepositoryRxjava(
        api: ApiServiceRxjava
    ): RepositoryRxjava{
        return RepositoryRxjava(api)
    }
}