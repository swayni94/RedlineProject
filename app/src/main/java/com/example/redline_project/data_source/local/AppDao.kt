package com.example.redline_project.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.redline_project.models.DogType

@Dao
interface AppDao {
    @Query("Select * from DogType")
    suspend fun getListDog(): DogType

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setListDog(dogType: List<DogType>)
}