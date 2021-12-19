package com.example.registrationthengames.interactor

import com.example.registrationthengames.main.modelGames.GameResult
import com.example.registrationthengames.repository.GamesLocalRepository
import com.example.registrationthengames.repository.GamesRemoteRepository
import kotlinx.coroutines.flow.Flow

class InteractorGames(
    private val gamesLocalRepository: GamesLocalRepository,
    private val gamesRemoteRepository: GamesRemoteRepository,
) {

    suspend fun getActionGamesFromInteractor(): Flow<List<GameResult>> {
        return gamesLocalRepository.getActionListGamesLocalRepository()
    }
    suspend fun getRacingGamesFromInteractor(): Flow<List<GameResult>> {
        return gamesLocalRepository.getRacingListGamesLocalRepository()
    }
    suspend fun getShooterGamesFromInteractor(): Flow<List<GameResult>> {
        return gamesLocalRepository.getShooterListGamesLocalRepository()
    }

    suspend fun loadActionGamesFromInteractor(): List<GameResult> {
        val games = gamesRemoteRepository.loadActionGamesFromRemoteRepository()
        gamesLocalRepository.insertActionListGamesLocalRepository(games)
        return games
    }
    suspend fun loadRacingGamesFromInteractor(): List<GameResult> {
        val games = gamesRemoteRepository.loadActionGamesFromRemoteRepository()
        gamesLocalRepository.insertRacingListGamesLocalRepository(games)
        return games
    }
    suspend fun loadShooterGamesFromInteractor(): List<GameResult> {
        val games = gamesRemoteRepository.loadActionGamesFromRemoteRepository()
        gamesLocalRepository.insertShooterListGamesLocalRepository(games)
        return games
    }
}