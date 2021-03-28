package com.example.redline_project.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseResult (
    @SerializedName("message") val message : List<String>,
    @SerializedName("status") val status : String
): Serializable