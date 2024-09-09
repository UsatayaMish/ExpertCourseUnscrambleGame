package com.usatayamish.expertcourseunscramblegame.game

import android.view.KeyEvent
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.pressKey
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.isNotEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.usatayamish.expertcourseunscramblegame.R
import com.usatayamish.expertcourseunscramblegame.TextInputLayoutErrorEnabledMatcher
import com.usatayamish.expertcourseunscramblegame.TextInputLayoutHasErrorText
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class InputUi(
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
) {

    private val inputLayoutId: Int = R.id.inputLayout
    private val layoutInteraction: ViewInteraction = onView(
        allOf(
            containerIdMatcher,
            containerClassTypeMatcher,
            withId(inputLayoutId),
            isAssignableFrom(TextInputLayout::class.java)
        )
    )

    private val inputInteraction: ViewInteraction = onView(
        allOf(
            isAssignableFrom(TextInputEditText::class.java),
            withId(R.id.inputEditText),
            withParent(withId(inputLayoutId)),
            withParent(isAssignableFrom(TextInputLayout::class.java))
        )
    )

    private val textInputLayoutErrorEnabledMatcher = TextInputLayoutErrorEnabledMatcher(false)

    fun assertInitialState() {
        layoutInteraction.check(matches(isEnabled())).check(matches(textInputLayoutErrorEnabledMatcher))
        inputInteraction.check(matches(withText("")))
    }

    fun addInput(text: String) {
        inputInteraction.perform(typeText(text), closeSoftKeyboard())
    }

    fun assertInsufficientState() {
        layoutInteraction.check(matches(isEnabled())).check(matches(textInputLayoutErrorEnabledMatcher))
    }

    fun assertSufficientState() {
        layoutInteraction.check(matches(isEnabled())).check(matches(textInputLayoutErrorEnabledMatcher))
    }

    fun assertCorrectState() {
        layoutInteraction.check(matches(isNotEnabled())).check(matches(textInputLayoutErrorEnabledMatcher))
    }

    fun removeInputLastLetter() {
        inputInteraction.perform(click(), pressKey(KeyEvent.KEYCODE_DEL), closeSoftKeyboard())
    }

    fun assertIncorrectState() {
        layoutInteraction.check(matches(isEnabled())).check(matches(TextInputLayoutErrorEnabledMatcher(true)))
            .check(matches(TextInputLayoutHasErrorText(R.string.incorrect_message)))
    }
}
