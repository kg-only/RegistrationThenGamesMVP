package com.example.registrationthengames.responseModel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class ScreenshotResponse(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("image")
    val imageUrlScreen: String,
):Parcelable
