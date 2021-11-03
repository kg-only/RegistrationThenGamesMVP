package com.example.registrationthengames.modelGames

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResult(
    @SerializedName("id")
    val gameId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("released")
    val released: String?,
    @SerializedName("background_image")
    val imageUrl: String?,
    @SerializedName("rating")
    val rating: Float,
    @SerializedName("rating_top")
    val ratingTop: Float,
    @SerializedName("ratings_count")
    val ratingsCount: Int,
    @SerializedName("short_screenshots")
    val screenshots: List<ScreenshotResponse>,
    @SerializedName("platforms")
    val platforms: List<PlatformDataResponse>
) : Parcelable

