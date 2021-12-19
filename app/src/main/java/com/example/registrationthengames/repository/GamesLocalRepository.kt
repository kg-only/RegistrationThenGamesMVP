package com.example.registrationthengames.repository

import com.example.registrationthengames.main.modelGames.GameResult
import kotlinx.coroutines.flow.Flow

interface GamesLocalRepository {
    suspend fun insertActionListGamesLocalRepository(games:List<GameResult>)
    suspend fun insertRacingListGamesLocalRepository(games:List<GameResult>)
    suspend fun insertShooterListGamesLocalRepository(games:List<GameResult>)

    suspend fun getActionListGamesLocalRepository(): Flow<List<GameResult>>
    suspend fun getRacingListGamesLocalRepository(): Flow<List<GameResult>>
    suspend fun getShooterListGamesLocalRepository(): Flow<List<GameResult>>
}