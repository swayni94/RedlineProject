package com.example.redline_project.api

import com.example.redline_project.models.ResponseResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/breed/{dogtype}/images")
    suspend fun getListDog(@Path( value = "dogtype", encoded = true) dogtype: String): ResponseResult
}