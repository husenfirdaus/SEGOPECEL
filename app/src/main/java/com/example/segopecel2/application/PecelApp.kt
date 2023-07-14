package com.example.segopecel2.application

import android.app.Application
import com.example.segopecel2.repository.Pecelrepository

class PecelApp:Application() {
    val database by lazy { PecelDatabase.getDatabase(this) }
    val repository by lazy { Pecelrepository(database.Peceldao()) }
}