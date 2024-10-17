package com.usatayamish.expertcourseunscramblegame

import android.view.View
import com.usatayamish.expertcourseunscramblegame.views.check.UpdateCheckButton
import org.junit.Assert.assertEquals


import org.junit.Test


class CheckUiStateTest {

    @Test
    fun testEnabled() {
        val enabled = CheckUiState.Enabled

        val button = FakeButton()
        enabled.update(button)

        assertEquals(View.VISIBLE, button.visibility)
        assertEquals(true, button.enabled)
    }

    @Test
    fun testDisabled() {
        val disabled = CheckUiState.Disabled

        val button = FakeButton()
        disabled.update(button)

        assertEquals(View.VISIBLE, button.visibility)
        assertEquals(false, button.enabled)
    }

    @Test
    fun testInvisible() {
        val invisible = CheckUiState.Invisible

        val button = FakeButton()
        invisible.update(button)

        assertEquals(View.GONE, button.visibility)
        assertEquals(false, button.enabled)
    }

}

private class FakeButton: UpdateCheckButton{

    override fun update(uiState: CheckUiState) {
        throw IllegalStateException("not used here")
    }

    var visibility: Int? = null
    var enabled: Boolean? = null

    override fun update(visibility: Int, enabled: Boolean) {
        this.visibility = visibility
        this.enabled = enabled
    }


}