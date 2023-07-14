package com.example.segopecel2.repository

import com.example.segopecel2.dao.Peceldao
import com.example.segopecel2.model.Pecel
import kotlinx.coroutines.flow.Flow

class Pecelrepository(private val Peceldao: Peceldao){
    val allPecel: Flow<List<Pecel>> = Peceldao.getALLvPecels()
    suspend fun insertPecel(pecel: Pecel){
        Peceldao.InsertPecel(pecel)

        }
    suspend fun deletePecel(pecel: Pecel){
        Peceldao.DeletePecel(pecel)
    }
     suspend fun UpdatePecel(pecel: Pecel){
        Peceldao.UpdatePecel(pecel)
    }
}

