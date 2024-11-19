package com.usatayamish.expertcourseunscramblegame.views.stats

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.usatayamish.expertcourseunscramblegame.R

class StatsTextView: AppCompatTextView, UpdateStats {

    private lateinit var state: StatsUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val savedState = StatsSavedState(it)
            savedState.save(state)
            return savedState
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as StatsSavedState
        super.onRestoreInstanceState(restoredState.superState)
        update(restoredState.restore())
    }

    override fun update(uiState: StatsUiState) {
        state = uiState
        state.update(this)
    }

    override fun update(skips: Int, fails: Int, corrects: Int) {
        text = resources.getString(R.string.stats, skips, fails, corrects)
    }
}

interface UpdateStats {

    fun update(uiState: StatsUiState)

    fun update(skips: Int, fails: Int, corrects: Int)
}