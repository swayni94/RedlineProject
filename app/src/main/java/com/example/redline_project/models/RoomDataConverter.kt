package com.example.redline_project.models

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type

class RoomDataConverter: Serializable {
    @TypeConverter
    fun stringFromObject(list: DogType?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun getObjectFromString(jsonString: String?): DogType? {
        val listType: Type = object : TypeToken<DogType?>() {}.type
        return Gson().fromJson(jsonString, listType)
    }


    @TypeConverter
    fun stringFromListObject(list: List<DogType?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun getListObjectFromString(jsonString: String?): List<DogType?>? {
        val listType: Type = object : TypeToken<ArrayList<DogType?>?>() {}.type
        return Gson().fromJson(jsonString, listType)
    }

}