package com.example.registrationthengames.main.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.registrationthengames.main.db.convertors.Convertors
import com.example.registrationthengames.main.db.convertors.RoomConvertor
import com.example.registrationthengames.main.db.dao.GameDao
import com.example.registrationthengames.main.db.dbmodels.GameEntity

@Database(entities = [GameEntity::class],  version = 1)
abstract class GamesDataBase : RoomDatabase() {
    abstract fun resultFromDataBase(): GameDao
}