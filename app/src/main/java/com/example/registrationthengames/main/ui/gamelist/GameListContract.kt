package com.example.registrationthengames.main.ui.gamelist

import com.example.registrationthengames.main.modelGames.GameResult
import com.example.registrationthengames.common.mvp.MvpPresenter
import com.example.registrationthengames.common.mvp.MvpView

interface GameListContract {
    interface View : MvpView {
        fun showActionGameListActionFromDb(list: List<GameResult>)
        fun showRacingGameListActionFromDb(list: List<GameResult>)
        fun showShooterGameListActionFromDb(list: List<GameResult>)
    }

    interface Presenter : MvpPresenter<View> {
        fun loadDataGameList()
        fun getActionFromFlowList()
        fun getRacingFromFlowList()
        fun getShooterFromFlowList()
    }
}