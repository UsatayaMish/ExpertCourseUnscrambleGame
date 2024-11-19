package com.usatayamish.expertcourseunscramblegame.stats

import android.view.View
import android.widget.FrameLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.usatayamish.expertcourseunscramblegame.R
import com.usatayamish.expertcourseunscramblegame.game.ButtonUi
import org.hamcrest.Matcher

class StatsPage(skips: Int, fails: Int, corrects: Int) {

    private val containerIdMatcher: Matcher<View> = withParent(withId(R.id.statsLayout))
    private val containerClassTypeMatcher: Matcher<View> =
        withParent(isAssignableFrom(FrameLayout::class.java))

    private val statsUi = StatsUi(
        skips = skips,
        fails = fails,
        corrects = corrects,
        containerIdMatcher,
        containerClassTypeMatcher
    )

    private val newGameUi = ButtonUi(
        R.id.newGameButton,
        R.string.new_game,
        "#FF000000",
        containerIdMatcher,
        containerClassTypeMatcher
    )

    fun assertInitialState() {
        statsUi.assertVisible()
        newGameUi.assertVisible()
    }

    fun clickNewGame() {
        newGameUi.click()
    }

    fun assertNotVisible() {
        statsUi.assertDoesNotExist()
    }


}
