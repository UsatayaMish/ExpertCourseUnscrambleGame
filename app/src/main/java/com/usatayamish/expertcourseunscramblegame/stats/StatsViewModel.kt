package com.usatayamish.expertcourseunscramblegame.stats

import com.usatayamish.expertcourseunscramblegame.views.stats.StatsUiState

class StatsViewModel(private val repository: StatsRepository) {

    fun init(isFirstRun: Boolean): StatsUiState {
        return if (isFirstRun) {
            val (skips, fails, corrects) = repository.stats()
            StatsUiState.Base(skips, fails, corrects)
        } else {
            StatsUiState.Empty
        }
    }

    fun clear() {
        repository.clear()
    }

}
