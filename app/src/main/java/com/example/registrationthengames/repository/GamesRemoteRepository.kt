package com.example.registrationthengames.repository

import com.example.registrationthengames.main.modelGames.GameResult

interface GamesRemoteRepository {
    suspend fun loadActionGamesFromRemoteRepository():List<GameResult>
    suspend fun loadActionRacingFromRemoteRepository():List<GameResult>
    suspend fun loadActionShooterFromRemoteRepository():List<GameResult>
}