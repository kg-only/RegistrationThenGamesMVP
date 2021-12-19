package com.example.registrationthengames.repository

import com.example.registrationthengames.main.db.convertors.GamesConvertor
import com.example.registrationthengames.main.db.dao.GameDao
import com.example.registrationthengames.main.modelGames.GameResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GamesDataBaseRepository(private val gameDao: GameDao) : GamesLocalRepository {

    override suspend fun insertActionListGamesLocalRepository(games: List<GameResult>) {
        val entity = games.map { GamesConvertor.toDatabase(it) }
        gameDao.insertAll(entity)
    }

    override suspend fun insertRacingListGamesLocalRepository(games: List<GameResult>) {
        val entity = games.map { GamesConvertor.toDatabase(it) }
        gameDao.insertAll(entity)
    }

    override suspend fun insertShooterListGamesLocalRepository(games: List<GameResult>) {
        val entity = games.map { GamesConvertor.toDatabase(it) }
        gameDao.insertAll(entity)
    }


    override suspend fun getActionListGamesLocalRepository(): Flow<List<GameResult>> {
        return gameDao.getAll().map { list -> list.map { GamesConvertor.fromDatabase(it) } }
    }

    override suspend fun getRacingListGamesLocalRepository(): Flow<List<GameResult>> {
        return gameDao.getAll().map { list -> list.map { GamesConvertor.fromDatabase(it) } }
    }

    override suspend fun getShooterListGamesLocalRepository(): Flow<List<GameResult>> {
        return gameDao.getAll().map { list -> list.map { GamesConvertor.fromDatabase(it) } }
    }

}