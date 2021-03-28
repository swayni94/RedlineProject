package com.example.redline_project.repository2

import com.example.redline_project.models.ResponseResult
import io.reactivex.Single

class RepositoryRxjava(
    private val api:ApiServiceRxjava
) {

    fun getListdata(dogType:String):Single<ResponseResult>{
        return api.getListDog(dogType)
    }
}