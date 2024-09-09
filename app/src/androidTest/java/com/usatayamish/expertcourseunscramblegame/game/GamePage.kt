package com.usatayamish.expertcourseunscramblegame.game

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.usatayamish.expertcourseunscramblegame.R
import org.hamcrest.Matcher

class GamePage(word: String) {

    private val containerIdMatcher: Matcher<View> = withParent(withId(R.id.rootLayout))
    private val containerClassTypeMatcher: Matcher<View> = withParent(isAssignableFrom(LinearLayout::class.java))

    private val shuffledWordUi = ShuffledWordUi(
        text = word,
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = containerClassTypeMatcher
    )

    private val inputUi = InputUi(
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = containerClassTypeMatcher
    )

    private val nextUi = ButtonUi(
        id = R.id.nextButton,
        textResId = R.string.next,
        colorHex = "#56CEF3",
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = containerClassTypeMatcher
    )

    private val checkUi = CheckButtonUi(
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = containerClassTypeMatcher
    )

    private val skipUi = ButtonUi(
        id = R.id.skipButton,
        textResId = R.string.skip,
        colorHex = "#FF60FA",
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = containerClassTypeMatcher
    )

    fun assertInitialState() {
        shuffledWordUi.assertTextVisible()
        inputUi.assertInitialState()
        checkUi.assertVisibleDisabled()
        skipUi.assertVisible()
        nextUi.assertNotVisible()
    }

    fun addInput(text: String) {
        inputUi.addInput(text = text)
    }

    fun assertInsufficientState() {
        shuffledWordUi.assertTextVisible()
        inputUi.assertInsufficientState()
        checkUi.assertVisibleDisabled()
        skipUi.assertVisible()
        nextUi.assertNotVisible()
    }

    fun assertSufficientState() {
        shuffledWordUi.assertTextVisible()
        inputUi.assertSufficientState()
        checkUi.assertVisibleEnabled()
        skipUi.assertVisible()
        nextUi.assertNotVisible()
    }

    fun clickCheck() {
        checkUi.click()
    }

    fun clickNext() {
        nextUi.click()
    }

    fun assertCorrectState() {
        shuffledWordUi.assertTextVisible()
        inputUi.assertCorrectState()
        checkUi.assertNotVisible()
        skipUi.assertNotVisible()
        nextUi.assertVisible()
    }

    fun clickSkip() {
        skipUi.click()
    }

    fun removeInputLastLetter() {
        inputUi.removeInputLastLetter()
    }

    fun assertIncorrectState() {
        shuffledWordUi.assertTextVisible()
        inputUi.assertIncorrectState()
        checkUi.assertVisibleDisabled()
        skipUi.assertVisible()
        nextUi.assertNotVisible()
    }





}