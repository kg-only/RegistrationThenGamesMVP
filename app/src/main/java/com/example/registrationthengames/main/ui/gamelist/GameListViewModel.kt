package com.example.registrationthengames.main.ui.gamelist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrationthengames.interactor.InteractorGames
import com.example.registrationthengames.main.modelGames.GameResult
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GameListViewModel(private val interactor: InteractorGames) : ViewModel() {
    val listLiveData = MutableLiveData<List<GameResult>>()
    val listLiveData2 = MutableLiveData<List<GameResult>>()
    val listLiveData3 = MutableLiveData<List<GameResult>>()

    init {
        viewModelScope.launch {
            interactor.getActionGamesFromInteractor().collect {
                listLiveData.value = it
            }
            interactor.getRacingGamesFromInteractor().collect {
                listLiveData2.value = it
            }
            interactor.getShooterGamesFromInteractor().collect {
                listLiveData3.value = it
            }
        }
    }

    fun loadGameList() = viewModelScope.launch {
        try {
            interactor.loadActionGamesFromInteractor()
            interactor.loadRacingGamesFromInteractor()
            interactor.loadShooterGamesFromInteractor()
        } catch (throwable: Throwable) {
            Log.e("###", "Error process in loadDataHeroes() ", throwable)
        }
    }
}