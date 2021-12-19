package com.example.registrationthengames.main.ui.gamelist

import android.util.Log
import com.example.registrationthengames.common.mvp.BasePresenter
import com.example.registrationthengames.interactor.InteractorGames
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GamesPresenter(private val interactor: InteractorGames) :
    BasePresenter<GameListContract.View>(),
    GameListContract.Presenter {

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)
    override fun loadDataGameList() {
        presenterScope.launch {
            try {
                interactor.loadActionGamesFromInteractor()
                interactor.loadRacingGamesFromInteractor()
                interactor.loadShooterGamesFromInteractor()
            } catch (throwable: Throwable) {
                Log.e("###", "Error process in loadGamesFromInteractor() ", throwable)
            }
        }
    }
    override fun getActionFromFlowList() {
        presenterScope.launch {
            interactor.getActionGamesFromInteractor().collect {
                view?.showActionGameListActionFromDb(it)
            }
        }
    }

    override fun getRacingFromFlowList() {
        presenterScope.launch {
            interactor.getRacingGamesFromInteractor().collect {
                view?.showRacingGameListActionFromDb(it)
            }
        }
    }

    override fun getShooterFromFlowList() {
        presenterScope.launch {
            interactor.getShooterGamesFromInteractor().collect {
                view?.showShooterGameListActionFromDb(it)
            }
        }
    }
}
