package com.example.redline_project.repository

import com.example.redline_project.data.ResultData
import com.example.redline_project.data_source.local.AppDao
import com.example.redline_project.data_source.remote.RemoteDataSource
import com.example.redline_project.injection.IoDispatcher
import com.example.redline_project.models.ResponseResult
import io.reactivex.Single
import kotlinx.coroutines.CoroutineDispatcher

class AppRepository(
    private val remoteDataSource: RemoteDataSource,
   // private val appDao: AppDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
    ) : IAppRepository {
    override suspend fun getdogtypelist(dogtype:String): ResultData<ResponseResult> {

        return when (val result = remoteDataSource.getDogTypeList(dogtype)){
            is ResultData.Success->{
                val response = result.data
           /*     val dogImages=ArrayList<DogType> ()
                for(item in response.message){
                    dogImages.add(DogType(id = 0,type = dogtype, imagelink = item))
                }
                withContext(ioDispatcher){appDao.setListDog(dogImages)}*/
                ResultData.Success(response)
            }
            is ResultData.Error->{
                ResultData.Error(Exception("Data not found"))
            }
        }
    }
}