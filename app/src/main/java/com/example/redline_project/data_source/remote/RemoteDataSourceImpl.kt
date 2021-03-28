package com.example.redline_project.data_source.remote

import com.example.redline_project.api.ApiService
import com.example.redline_project.data.ResultData
import com.example.redline_project.injection.IoDispatcher
import com.example.redline_project.models.ResponseResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RemoteDataSourceImpl(
    private val api: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {
    override suspend fun getDogTypeList(dogtype:String): ResultData<ResponseResult> =
        withContext(ioDispatcher){
            val request = api.getListDog(dogtype)
            ResultData.Success(request)
        }

}