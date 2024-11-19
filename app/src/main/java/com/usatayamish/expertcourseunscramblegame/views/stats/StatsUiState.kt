package com.usatayamish.expertcourseunscramblegame.views.stats

import java.io.Serializable

interface StatsUiState: Serializable {

    fun update(statsTextView: UpdateStats)

    data class Base(
        private val skips: Int,
        private val fails: Int,
        private val corrects: Int
    ) : StatsUiState {

        override fun update(statsTextView: UpdateStats) {
            statsTextView.update(skips, fails, corrects)
        }

    }
}