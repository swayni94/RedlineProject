package com.example.redline_project.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "DogType")
data class DogType(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "Type")
    val type : String,
    @ColumnInfo(name = "ImageLink")
    val imagelink : String
) : Serializable

