package com.usatayamish.expertcourseunscramblegame

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get: Rule
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var gamePage: GamePage

    @Before
    fun setup(){
        gamePage = GamePage(word = "animal".reversed())

    }

    /**
     * UGTC-01
     */
    @Test
    fun caseNumber1() {
        gamePage.assertInitialState()

        gamePage.addInput(text = "animal")
        gamePage.assertSufficientState()

        gamePage.clickCheck()
        gamePage.assertCorrectState

        gamePage.clickNext()

        gamePage = GamePage(word = "auto".reversed())

        gamePage.assertInitialState()
    }

    /**
     * UGTC-02
     */
    @Test
    fun caseNumber2() {
        gamePage.assertInitialState()

        gamePage.addInput(text = "anima")
        gamePage.assertInsufficientState()

        gamePage.addInput(text = "l")
        gamePage.assertSufficientState()

        gamePage.clickCheck()
        gamePage.assertCorrectState

        gamePage.clickNext()

        gamePage = GamePage(word = "auto".reversed())

        gamePage.assertInitialState()
    }

    /**
     * UGTC-03
     */
    @Test
    fun caseNumber3() {
        gamePage.assertInitialState()

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        gamePage.assertInitialState()

    }

    /**
     * UGTC-04
     */
    @Test
    fun caseNumber4() {
        gamePage.assertInitialState()

        gamePage.addInput(text = "anima")
        gamePage.assertInsufficientState()

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        gamePage.assertInitialState()
    }

    /**
     * UGTC-05
     */
    @Test
    fun caseNumber5() {
        gamePage.assertInitialState()

        gamePage.addInput(text = "anima")
        gamePage.assertInsufficientState()

        gamePage.addInput(text = "l")
        gamePage.assertSufficientState()

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        gamePage.assertInitialState()
    }

    /**
     * UGTC-06
     */
    @Test
    fun caseNumber6() {
        gamePage.assertInitialState()

        gamePage.addInput(text = "anima")
        gamePage.assertInsufficientState()

        gamePage.addInput(text = "l")
        gamePage.assertSufficientState()

        gamePage.removeInputLastLetter()
        gamePage.assertInsufficientState()

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        gamePage.assertInitialState()
    }

    /**
     * UGTC-07
     */
    @Test
    fun caseNumber7() {
        gamePage.assertInitialState()

        gamePage.addInput(text = "anima")
        gamePage.assertInsufficientState()

        gamePage.addInput(text = "h")
        gamePage.assertSufficientState()

        gamePage.clickCheck()
        gamePage.assertIncorrectState()

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        gamePage.assertInitialState()
    }

    /**
     * UGTC-08
     */
    @Test
    fun caseNumber8() {
        gamePage.assertInitialState()

        gamePage.addInput(text = "anima")
        gamePage.assertInsufficientState()

        gamePage.addInput(text = "h")
        gamePage.assertSufficientState()

        gamePage.clickCheck()
        gamePage.assertIncorrectState()

        gamePage.removeInputLastLetter()
        gamePage.assertInsufficientState()

        gamePage.addInput(text = "h")
        gamePage.assertSufficientState()

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        gamePage.assertInitialState()
    }

    /**
     * UGTC-09
     */
    @Test
    fun caseNumber9() {
        gamePage.assertInitialState()

        gamePage.addInput(text = "anima")
        gamePage.assertInsufficientState()

        gamePage.addInput(text = "h")
        gamePage.assertSufficientState()

        gamePage.clickCheck()
        gamePage.assertIncorrectState()

        gamePage.removeInputLastLetter()
        gamePage.assertInsufficientState()

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        gamePage.assertInitialState()
    }

    /**
     * UGTC-10
     */
    @Test
    fun caseNumber10() {
        gamePage.assertInitialState()

        gamePage.addInput(text = "anima")
        gamePage.assertInsufficientState()

        gamePage.addInput(text = "h")
        gamePage.assertSufficientState()

        gamePage.clickCheck()
        gamePage.assertIncorrectState()

        gamePage.removeInputLastLetter()
        gamePage.assertInsufficientState()

        gamePage.addInput(text = "l")
        gamePage.assertSufficientState()

        gamePage.clickCheck()
        gamePage.assertCorrectState()

        gamePage.clickNext()

        gamePage = GamePage(word = "auto".reversed())

        gamePage.assertInitialState()
    }
}

