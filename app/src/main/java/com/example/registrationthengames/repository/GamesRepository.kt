package com.example.registrationthengames.repository

import com.example.registrationthengames.main.api.RetrofitService
import com.example.registrationthengames.main.modelGames.GameResult

class GamesRepository(private val api: RetrofitService) : GamesRemoteRepository {
    override suspend fun loadActionGamesFromRemoteRepository(): List<GameResult> {
        val action = api.getGames(1, 50, "action")
        return action.results.map {
            GameResult(gameId = it.gameId,
                name = it.name,
                slug = it.slug,
                released = it.released,
                imageUrl = it.imageUrl,
                rating = it.rating,
                ratingTop = it.ratingTop,
                ratingsCount = it.ratingsCount,
                screenshots = it.screenshots)
//                platforms = it.platforms)
        }
    }

    override suspend fun loadActionRacingFromRemoteRepository(): List<GameResult> {
        val action = api.getGames(1, 50, "racing")
        return action.results.map {
            GameResult(gameId = it.gameId,
                name = it.name,
                slug = it.slug,
                released = it.released,
                imageUrl = it.imageUrl,
                rating = it.rating,
                ratingTop = it.ratingTop,
                ratingsCount = it.ratingsCount,
                screenshots = it.screenshots)
//                platforms = it.platforms)
        }
    }

    override suspend fun loadActionShooterFromRemoteRepository(): List<GameResult> {
        val action = api.getGames(1, 50, "shooter")
        return action.results.map {
            GameResult(gameId = it.gameId,
                name = it.name,
                slug = it.slug,
                released = it.released,
                imageUrl = it.imageUrl,
                rating = it.rating,
                ratingTop = it.ratingTop,
                ratingsCount = it.ratingsCount,
                screenshots = it.screenshots)
//                platforms = it.platforms)
        }
    }
}