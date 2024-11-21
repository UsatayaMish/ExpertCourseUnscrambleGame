package com.usatayamish.expertcourseunscramblegame.game

class GameViewModel(
    private val repository: GameRepository
) {

    fun init(isFirstRun: Boolean = true): GameUiState {
        return if(isFirstRun) {
            if(repository.isLastWord()) {
                GameUiState.Finish
            } else {
                GameUiState.Initial(repository.shuffledWord(), repository.userInput())
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
