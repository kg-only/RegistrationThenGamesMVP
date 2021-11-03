package com.example.registrationthengames.modelGames

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScreenshotResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val imageUrlScreen: String
):Parcelable
