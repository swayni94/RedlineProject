package com.example.redline_project.repository

import com.example.redline_project.data.ResultData
import com.example.redline_project.models.ResponseResult
import io.reactivex.Single

interface IAppRepository {
    suspend fun getdogtypelist(dogtype:String): ResultData<ResponseResult>
}