package com.example.registrationthengames.main.modelGames

import android.os.Parcelable
import com.example.registrationthengames.responseModel.ScreenshotResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResult(
    val gameId: Int,
    val name: String,
    val slug: String,
    val released: String?,
    val imageUrl: String?,
    val rating: Float,
    val ratingTop: Float,
    val ratingsCount: Int,
    val screenshots: List<ScreenshotResponse>,
//    val platforms: List<PlatformDataResponse>,
) : Parcelable

