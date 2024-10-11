package com.usatayamish.expertcourseunscramblegame

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.usatayamish.expertcourseunscramblegame.game.GamePage

import org.junit.Test
import org.junit.runner.RunWith

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

        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }


        gamePage.addInput(text = "animal")
        scenarioRule.doWithRecreate {
            gamePage.assertSufficientState()
        }

        gamePage.clickCheck()
        scenarioRule.doWithRecreate {
            gamePage.assertCorrectState()
        }


        gamePage.clickNext()

        gamePage = GamePage(word = "auto".reversed())


        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }
    }


    /**
     * UGTC-02
     */
    @Test
    fun caseNumber2() {
        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }

        gamePage.addInput(text = "anima")
        scenarioRule.doWithRecreate {
            gamePage.assertInsufficientState()
        }

        gamePage.addInput(text = "l")
        scenarioRule.doWithRecreate {
            gamePage.assertSufficientState()
        }

        gamePage.clickCheck()
        scenarioRule.doWithRecreate {
            gamePage.assertCorrectState()
        }

        gamePage.clickNext()

        gamePage = GamePage(word = "auto".reversed())

        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }

    }

    /**
     * UGTC-03
     */
    @Test
    fun caseNumber3() {
        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }

    }

    /**
     * UGTC-04
     */
    @Test
    fun caseNumber4() {
        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }

        gamePage.addInput(text = "anima")
        scenarioRule.doWithRecreate {
            gamePage.assertInsufficientState()
        }

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }
    }

    /**
     * UGTC-05
     */
    @Test
    fun caseNumber5() {
        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }

        gamePage.addInput(text = "anima")
        scenarioRule.doWithRecreate {
            gamePage.assertInsufficientState()
        }

        gamePage.addInput(text = "l")
        scenarioRule.doWithRecreate {
            gamePage.assertSufficientState()
        }

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }
    }

    /**
     * UGTC-06
     */
    @Test
    fun caseNumber6() {
        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }

        gamePage.addInput(text = "anima")
        scenarioRule.doWithRecreate {
            gamePage.assertInsufficientState()
        }

        gamePage.addInput(text = "l")
        scenarioRule.doWithRecreate {
            gamePage.assertSufficientState()
        }

        gamePage.removeInputLastLetter()
        scenarioRule.doWithRecreate {
            gamePage.assertInsufficientState()
        }

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }
    }

    /**
     * UGTC-07
     */
    @Test
    fun caseNumber7() {
        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }

        gamePage.addInput(text = "anima")
        scenarioRule.doWithRecreate {
            gamePage.assertInsufficientState()
        }

        gamePage.addInput(text = "h")
        scenarioRule.doWithRecreate {
            gamePage.assertSufficientState()
        }

        gamePage.clickCheck()
        scenarioRule.doWithRecreate {
            gamePage.assertIncorrectState()
        }

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }
    }

    /**
     * UGTC-08
     */
    @Test
    fun caseNumber8() {
        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }

        gamePage.addInput(text = "anima")
        scenarioRule.doWithRecreate {
            gamePage.assertInsufficientState()
        }

        gamePage.addInput(text = "h")
        scenarioRule.doWithRecreate {
            gamePage.assertSufficientState()
        }

        gamePage.clickCheck()
        scenarioRule.doWithRecreate {
            gamePage.assertIncorrectState()
        }

        gamePage.removeInputLastLetter()
        scenarioRule.doWithRecreate {
            gamePage.assertInsufficientState()
        }

        gamePage.addInput(text = "h")
        scenarioRule.doWithRecreate {
            gamePage.assertSufficientState()
        }

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }
    }

    /**
     * UGTC-09
     */
    @Test
    fun caseNumber9() {
        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }

        gamePage.addInput(text = "anima")
        scenarioRule.doWithRecreate {
            gamePage.assertInsufficientState()
        }

        gamePage.addInput(text = "h")
        scenarioRule.doWithRecreate {
            gamePage.assertSufficientState()
        }

        gamePage.clickCheck()
        scenarioRule.doWithRecreate {
            gamePage.assertIncorrectState()
        }

        gamePage.removeInputLastLetter()
        scenarioRule.doWithRecreate {
            gamePage.assertInsufficientState()
        }

        gamePage.clickSkip()

        gamePage = GamePage(word = "auto".reversed())

        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }
    }

    /**
     * UGTC-10
     */
    @Test
    fun caseNumber10() {
        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }

        gamePage.addInput(text = "anima")
        scenarioRule.doWithRecreate {
            gamePage.assertInsufficientState()
        }

        gamePage.addInput(text = "h")
        scenarioRule.doWithRecreate {
            gamePage.assertSufficientState()
        }

        gamePage.clickCheck()
        scenarioRule.doWithRecreate {
            gamePage.assertIncorrectState()
        }

        gamePage.removeInputLastLetter()
        scenarioRule.doWithRecreate {
            gamePage.assertInsufficientState()
        }

        gamePage.addInput(text = "l")
        scenarioRule.doWithRecreate {
            gamePage.assertSufficientState()
        }

        gamePage.clickCheck()
        scenarioRule.doWithRecreate {
            gamePage.assertCorrectState()
        }

        gamePage.clickNext()

        gamePage = GamePage(word = "auto".reversed())

        scenarioRule.doWithRecreate {
            gamePage.assertInitialState()
        }
    }

    private fun ActivityScenarioRule<*>.doWithRecreate(block: ()->Unit) {
        block.invoke()
        scenario.recreate()
        block.invoke()
    }
}

