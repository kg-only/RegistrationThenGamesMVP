package com.example.registrationthengames.main.modelGames

import android.os.Parcelable
import androidx.room.*
import com.example.registrationthengames.main.db.convertors.RoomConvertor
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Screenshots(
    val id: Int,
    val imageUrlScreen: String,
) : Parcelable
