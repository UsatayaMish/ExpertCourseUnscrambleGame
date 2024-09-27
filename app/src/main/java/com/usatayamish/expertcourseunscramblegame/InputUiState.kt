package com.usatayamish.expertcourseunscramblegame

import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

interface InputUiState {

    fun update(
        inputLayout: TextInputLayout,
        inputEditText: TextInputEditText
    )

    abstract class Abstract(
        private val errorIsVisible: Boolean,
        private val enabled: Boolean,
        private val clearText: Boolean
    ) : InputUiState {

        override fun update(inputLayout: TextInputLayout, inputEditText: TextInputEditText) {
            inputLayout.isErrorEnabled = errorIsVisible
            if(errorIsVisible)
                inputLayout.error = inputLayout.context.getString(R.string.incorrect_message)
            inputLayout.isEnabled = enabled
            if(clearText)
                inputEditText.setText("")
        }
    }

    object Initial : Abstract(
        false,
        true,
        true
    )

    object EnabledNoError : Abstract(
        false,
        true,
        false
    )

    object Correct : Abstract(
        false,
        false,
        false
        )

    object Incorrect : Abstract(
        true,
        true,
        false
    )

}