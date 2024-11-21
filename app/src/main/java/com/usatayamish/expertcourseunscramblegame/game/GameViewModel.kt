package com.usatayamish.expertcourseunscramblegame.game

import com.usatayamish.expertcourseunscramblegame.di.ClearViewModel
import com.usatayamish.expertcourseunscramblegame.di.MyViewModel

class GameViewModel(
    private val repository: GameRepository,
    private val clearViewModel: ClearViewModel
) : MyViewModel{

    fun init(isFirstRun: Boolean = true): GameUiState {
        return if(isFirstRun) {
            if(repository.isLastWord()) {
                clearViewModel.clear(this::class.java)
                GameUiState.Finish
            } else {
                val shuffledWord = repository.shuffledWord()
                val userInput = repository.userInput()

                GameUiState.Initial(shuffledWord, userInput)
            }
        } else {
            GameUiState.Empty
        }
    }

    fun next(): GameUiState {
        repository.next()
        return init()
    }

    fun check(text: String): GameUiState {
        val isCorrect = repository.isCorrect(text)
        return if(isCorrect)
            GameUiState.Correct
        else
            GameUiState.Incorrect
    }

    fun skip(): GameUiState {
        repository.skip()
        return init()
    }

    fun handleUserInput(text: String): GameUiState {
        repository.saveUserInput(text)
        val shuffledWord = repository.shuffledWord()
        val isSufficient = text.length == shuffledWord.length
        return if(isSufficient)
            GameUiState.Sufficient
        else
            GameUiState.Insufficient
    }


}
