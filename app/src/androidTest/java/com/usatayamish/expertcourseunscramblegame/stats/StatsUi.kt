package com.usatayamish.expertcourseunscramblegame.stats

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.usatayamish.expertcourseunscramblegame.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class StatsUi(
    skips: Int,
    fails: Int,
    corrects: Int,
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
) {
    private val interaction: ViewInteraction =
        onView(
            allOf(
                withId(R.id.statsTextView),
                isAssignableFrom(TextView::class.java),
                withText("Game Over\n\nSkips: $skips\nFails: $fails\nCorrects: $corrects"),
                containerIdMatcher,
                containerClassTypeMatcher
            )
        )

    fun assertVisible() {
        interaction.check(matches(isCompletelyDisplayed()))
    }

    fun assertDoesNotExist() {
        interaction.check(doesNotExist())
    }


}
