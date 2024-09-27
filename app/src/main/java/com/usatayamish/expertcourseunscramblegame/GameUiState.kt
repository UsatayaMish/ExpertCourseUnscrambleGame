package com.usatayamish.expertcourseunscramblegame

import android.view.View
import com.usatayamish.expertcourseunscramblegame.databinding.ActivityMainBinding

interface GameUiState {

    fun update(binding: ActivityMainBinding)

    abstract class Abstract(
        private val shuffledValue: String,
        private val inputUiState: InputUiState,
        private val skipVisibility: Int,
        private val checkUiState: CheckUiState,
        private val nextVisibility: Int
    ) : GameUiState {

        override fun update(binding: ActivityMainBinding) = with(binding){
            shuffledWordTextView.text = shuffledValue
            inputUiState.update(inputLayout, inputEditText)
            skipButton.visibility = skipVisibility
            checkUiState.update(checkButton)
            nextButton.visibility = nextVisibility
        }
    }

    data class Initial(
        private val shuffledWord: String
    ) : Abstract(
        shuffledValue = shuffledWord,
        inputUiState = InputUiState.Initial,
        skipVisibility = View.VISIBLE,
        checkUiState = CheckUiState.Disabled,
        nextVisibility = View.GONE
    )

    data class Insufficient(
        private val shuffledWord: String
    ) : Abstract(
        shuffledValue = shuffledWord,
        inputUiState =  InputUiState.EnabledNoError,
        skipVisibility = View.VISIBLE,
        checkUiState = CheckUiState.Disabled,
        nextVisibility = View.GONE
        )

    data class Sufficient(
        private val shuffledWord: String
    ) : Abstract(
        shuffledValue = shuffledWord,
        inputUiState = InputUiState.EnabledNoError,
        skipVisibility = View.VISIBLE,
        checkUiState = CheckUiState.Enabled,
        nextVisibility = View.GONE
    )

    data class Incorrect(
        private val shuffledWord: String
    ) : Abstract(
        shuffledValue = shuffledWord,
        inputUiState = InputUiState.Incorrect,
        skipVisibility = View.VISIBLE,
        checkUiState = CheckUiState.Disabled,
        nextVisibility = View.GONE
    )

    data class Correct(
        private val shuffledWord: String
    ) : Abstract(
        shuffledValue = shuffledWord,
        inputUiState = InputUiState.Correct,
        skipVisibility = View.GONE,
        checkUiState = CheckUiState.Invisible,
        nextVisibility = View.VISIBLE
    )


}


