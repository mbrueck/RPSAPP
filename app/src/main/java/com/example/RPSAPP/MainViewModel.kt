package com.example.RPSAPP

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

enum class gameOption {
    STONE, PAPER, SCISSOR
}

enum class gameResult {
    WIN, LOSE, DRAW
}

class MainViewModel : ViewModel() {

    private val _playerChose = MutableLiveData<gameResult>()
    val playChose: LiveData<gameResult>
        get() = _playerChose


    fun playSystem(playerChoise: gameOption): gameResult {
        val computerChose = generateSequence()
        val result = roundResult(playerChoise, computerChose)
        return result
    }

    private fun generateSequence(): gameOption {
        val ramdumIndex = Random.nextInt(0, gameOption.values().size)
        return gameOption.values()[ramdumIndex]
    }

    private fun roundResult(playerChoise: gameOption, computerChose: gameOption): gameResult {
        if (playerChoise == computerChose) {
            return gameResult.DRAW
        }
        return when (playerChoise){
            gameOption.STONE -> if (computerChose == gameOption.SCISSOR) gameResult.WIN else gameResult.LOSE
            gameOption.SCISSOR -> if (computerChose == gameOption.PAPER) gameResult.WIN else gameResult.LOSE
            gameOption.PAPER -> if (computerChose == gameOption.SCISSOR) gameResult.WIN else gameResult.LOSE
        }
    }
}