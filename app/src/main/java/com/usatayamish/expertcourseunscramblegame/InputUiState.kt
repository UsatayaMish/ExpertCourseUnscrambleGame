package com.usatayamish.expertcourseunscramblegame

import com.usatayamish.expertcourseunscramblegame.views.input.UpdateInput
import java.io.Serializable

interface InputUiState : Serializable{

    fun update(updateInput: UpdateInput)

    abstract class Abstract(
        private val errorIsVisible: Boolean,
        private val enabled: Boolean
    ) : InputUiState {

        override fun update(updateInput: UpdateInput) {
            updateInput.update(errorIsVisible, enabled)
        }

    }

    data class Initial(private val userInput: String) : Abstract(
        false,
        true
    ) {
        override fun update(updateInput: UpdateInput) {
            super.update(updateInput)
            updateInput.update(userInput)
        }
    }

    object EnabledNoError : Abstract(
        false,
        true
    )

    object Correct : Abstract(
        false,
        false
        )

    object Incorrect : Abstract(
        true,
        true
    )

}