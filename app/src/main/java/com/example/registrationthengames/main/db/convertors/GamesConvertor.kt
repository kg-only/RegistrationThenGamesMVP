package com.example.registrationthengames.main.db.convertors

import com.example.registrationthengames.main.db.dbmodels.GameEntity
import com.example.registrationthengames.main.modelGames.GameResult

object GamesConvertor {
    fun toDatabase(game: GameResult): GameEntity =
        GameEntity(
            gameId = game.gameId,
            name = game.name,
            slug = game.slug,
            released = game.released,
            imageUrl = game.imageUrl,
            rating = game.rating,
            ratingTop = game.ratingTop,
            ratingsCount = game.ratingsCount,
            screenshots = game.screenshots,
//            platforms = game.platforms
        )

    fun fromDatabase(entity: GameEntity): GameResult =
        GameResult(gameId = entity.gameId,
            name = entity.name,
            slug = entity.slug,
            released = entity.released,
            imageUrl = entity.imageUrl,
            rating = entity.rating,
            ratingTop = entity.ratingTop,
            ratingsCount = entity.ratingsCount,
            screenshots = entity.screenshots,
//            platforms = entity.platforms
        )
}