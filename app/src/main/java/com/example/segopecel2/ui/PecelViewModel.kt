package com.example.segopecel2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.segopecel2.model.Pecel
import com.example.segopecel2.repository.Pecelrepository
import kotlinx.coroutines.launch

class PecelViewModel(private val repository: Pecelrepository): ViewModel() {
    val allPecels: LiveData<List<Pecel>> = repository.allPecel.asLiveData()

    fun insert(pecel: Pecel) = viewModelScope.launch {
        repository.insertPecel(pecel)
    }
    fun delete(pecel: Pecel) = viewModelScope.launch {
        repository.deletePecel(pecel)
    }
    fun updete(pecel: Pecel) = viewModelScope.launch {
        repository.UpdatePecel(pecel)
    }
    }

class PecelViewModelFactory(private val repository: Pecelrepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((PecelViewModel::class.java))) {
            return PecelViewModel(repository) as T

        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}