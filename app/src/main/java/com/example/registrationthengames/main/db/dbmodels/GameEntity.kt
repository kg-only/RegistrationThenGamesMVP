package com.example.registrationthengames.main.db.dbmodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.registrationthengames.main.db.convertors.Convertors
import com.example.registrationthengames.main.db.convertors.RoomConvertor
import com.example.registrationthengames.main.modelGames.Screenshots
import com.example.registrationthengames.responseModel.ScreenshotResponse

@Entity(tableName = "GamesDataBase")
@TypeConverters(RoomConvertor::class)
data class GameEntity(

    @PrimaryKey
    val gameId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "slug")
    val slug: String,
    @ColumnInfo(name = "released")
    val released: String?,
    @ColumnInfo(name = "background_image")
    val imageUrl: String?,
    @ColumnInfo(name = "rating")
    val rating: Float,
    @ColumnInfo(name = "rating_top")
    val ratingTop: Float,
    @ColumnInfo(name = "ratings_count")
    val ratingsCount: Int,
    @ColumnInfo(name = "short_screenshots")
    val screenshots: List<ScreenshotResponse>,

//    @ColumnInfo(name = "platforms")
//    val platforms: List<PlatformDataResponse>,
)


