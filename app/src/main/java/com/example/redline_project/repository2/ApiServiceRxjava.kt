package com.example.redline_project.repository2

import com.example.redline_project.models.ResponseResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceRxjava {
    @GET("/api/breed/{dogtype}/list")
    fun getListDog(@Path( value = "dogtype", encoded = true) dogtype: String): Single<ResponseResult>
}