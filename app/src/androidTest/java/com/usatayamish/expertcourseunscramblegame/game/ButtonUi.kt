package com.usatayamish.expertcourseunscramblegame.game

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.usatayamish.expertcourseunscramblegame.ButtonColorMatcher
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class ButtonUi (
    id: Int,
    textResId: Int,
    colorHex: String,
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
) : AbstractButtonUi(
    onView(
        allOf(
            withId(id),
            withText(textResId),
            ButtonColorMatcher(colorHex),
            containerIdMatcher,
            containerClassTypeMatcher,
            isAssignableFrom(AppCompatButton::class.java)
        )
    )
) {

}
