package com.example.segopecel2.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "pecel_pecel")
data class Pecel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val address: String,
    val sidedish: String,
    val drink: String,
    val price: String,
    val latitude: Double?,
    val longitude: Double?,
) : Parcelable
