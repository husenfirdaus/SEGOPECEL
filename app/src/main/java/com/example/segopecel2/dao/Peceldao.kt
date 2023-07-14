package com.example.segopecel2.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.segopecel2.model.Pecel
import kotlinx.coroutines.flow.Flow


@Dao
interface Peceldao{
    @Query("SELECT * FROM `pecel_pecel` ORDER BY name ASC")

    fun getALLvPecels(): Flow<List<Pecel>>

    @Insert
    suspend fun InsertPecel(pecel: Pecel)

    @Delete
    suspend fun DeletePecel(pecel: Pecel)

    @Update
    suspend fun UpdatePecel(pecel: Pecel)


}
