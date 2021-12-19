package com.example.registrationthengames.main.ui

import androidx.room.Room
import com.example.registrationthengames.interactor.InteractorGames
import com.example.registrationthengames.main.db.database.GamesDataBase
import com.example.registrationthengames.main.ui.gamelist.GameListContract
import com.example.registrationthengames.main.ui.gamelist.GameListViewModel
import com.example.registrationthengames.main.ui.gamelist.GamesPresenter
import com.example.registrationthengames.repository.GamesDataBaseRepository
import com.example.registrationthengames.repository.GamesLocalRepository
import com.example.registrationthengames.repository.GamesRemoteRepository
import com.example.registrationthengames.repository.GamesRepository
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create(): Module = module {
//        factory { GamesPresenter(get()) } bind GameListContract.Presenter::class
        factory { GameListViewModel(get()) }
        factory {
            val interactor = InteractorGames(get(), get())
            interactor
        } bind InteractorGames::class
        single {
            Room.databaseBuilder(get(), GamesDataBase::class.java, "GamesDataBase")
                .build()
        }
        single { get<GamesDataBase>().resultFromDataBase() }
        single<GamesLocalRepository> { GamesDataBaseRepository(get()) }
        single<GamesRemoteRepository> { GamesRepository(get()) }
    }
}