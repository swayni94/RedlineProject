package com.example.redline_project.data_source.remote

import com.example.redline_project.data.ResultData
import com.example.redline_project.models.ResponseResult
import io.reactivex.Single

interface RemoteDataSource {
    suspend fun getDogTypeList(dogtype:String): ResultData<ResponseResult>
}