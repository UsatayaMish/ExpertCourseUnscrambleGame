package com.usatayamish.expertcourseunscramblegame.game

import com.usatayamish.expertcourseunscramblegame.views.check.UpdateCheckButton
import com.usatayamish.expertcourseunscramblegame.views.input.UpdateInput
import com.usatayamish.expertcourseunscramblegame.views.shuffledword.UpdateText
import com.usatayamish.expertcourseunscramblegame.views.visibilitybutton.UpdateVisibility
import com.usatayamish.expertcourseunscramblegame.views.visibilitybutton.VisibilityUiState


interface GameUiState{

    fun update(
        shuffledWordTextView: UpdateText,
        inputView: UpdateInput,
        skip: UpdateVisibility,
        check: UpdateCheckButton,
        next: UpdateVisibility
    )

    object Empty : GameUiState {

        override fun update(
            shuffledWordTextView: UpdateText,
            inputView: UpdateInput,
            skip: UpdateVisibility,
            check: UpdateCheckButton,
            next: UpdateVisibility
        ) = Unit
    }

    abstract class Abstract(
        private val inputUiState: InputUiState,
        private val checkUiState: CheckUiState
    ) : GameUiState {

        override fun update(
            shuffledWordTextView: UpdateText,
            inputView: UpdateInput,
            skip: UpdateVisibility,
            check: UpdateCheckButton,
            next: UpdateVisibility
        ) {
            inputView.update(inputUiState)
            check.update(checkUiState)
        }

    }

    data class Initial(
        private val shuffledWord: String,
        private val userInput: String = ""
    ) : Abstract(
        inputUiState = InputUiState.Initial(userInput),
        checkUiState = CheckUiState.Disabled
    ) {

        override fun update(
            shuffledWordTextView: UpdateText,
            inputView: UpdateInput,
            skip: UpdateVisibility,
            check: UpdateCheckButton,
            next: UpdateVisibility
        ) {
            super.update(shuffledWordTextView, inputView, skip, check, next)
            shuffledWordTextView.update(shuffledWord)
            next.update(VisibilityUiState.Gone)
            skip.update(VisibilityUiState.Visible)
        }
    }

    object Insufficient : Abstract(
        inputUiState = InputUiState.EnabledNoError,
        checkUiState = CheckUiState.Disabled
        )

    object Sufficient : Abstract(
        inputUiState = InputUiState.EnabledNoError,
        checkUiState = CheckUiState.Enabled
    )

    object Incorrect : Abstract(
        inputUiState = InputUiState.Incorrect,
        checkUiState = CheckUiState.Disabled
    )

    object Correct : Abstract(
        inputUiState = InputUiState.Correct,
        checkUiState = CheckUiState.Invisible
    ) {

        override fun update(
            shuffledWordTextView: UpdateText,
            inputView: UpdateInput,
            skip: UpdateVisibility,
            check: UpdateCheckButton,
            next: UpdateVisibility
        ) {
            super.update(shuffledWordTextView, inputView, skip, check, next)
            next.update(VisibilityUiState.Visible)
            skip.update(VisibilityUiState.Gone)
        }
    }


}


