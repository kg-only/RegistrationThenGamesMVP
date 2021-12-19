package com.example.registrationthengames.main.db.convertors

import androidx.room.TypeConverter
import com.example.registrationthengames.main.db.dbmodels.GameEntity
import com.example.registrationthengames.main.modelGames.Screenshots
import com.example.registrationthengames.responseModel.ScreenshotResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class RoomConvertor {
    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<String?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<String?>?): String? {
        return gson.toJson(someObjects)
    }
    @TypeConverter
    fun listToJsonString(value: List<ScreenshotResponse>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<ScreenshotResponse>::class.java).toList()
}
//
//    @TypeConverter
//    fun someObjectListToString(someObjects: List<String?>?): String? {
//        return gson.toJson(someObjects)
//    }
//    @TypeConverter
//    fun listToJson(value: List<GameEntity>?) = Gson().toJson(value)
//
//    @TypeConverter
//    fun jsonToList(value: String) = Gson().fromJson(value, Array<GameEntity>::class.java).toList()
//}