package com.example.registrationthengames.main.db.dao

import androidx.room.*
import com.example.registrationthengames.main.db.convertors.Convertors
import com.example.registrationthengames.main.db.dbmodels.GameEntity
import com.example.registrationthengames.main.modelGames.Screenshots
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {
    @TypeConverters(Convertors::class)
    @Query("SELECT * FROM GamesDataBase")
    fun getAll(): Flow<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(resultInsert: List<GameEntity>)
}