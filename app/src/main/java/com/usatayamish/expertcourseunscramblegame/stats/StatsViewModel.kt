package com.usatayamish.expertcourseunscramblegame.stats

import com.usatayamish.expertcourseunscramblegame.di.ClearViewModel
import com.usatayamish.expertcourseunscramblegame.di.MyViewModel
import com.usatayamish.expertcourseunscramblegame.views.stats.StatsUiState

class StatsViewModel(
    private val repository: StatsRepository,
    private val clearViewModel: ClearViewModel
): MyViewModel {

    fun init(isFirstRun: Boolean): StatsUiState {
        return if (isFirstRun) {
            val (skips, fails, corrects) = repository.stats()
            repository.clear()
            StatsUiState.Base(skips, fails, corrects)
        } else {
            StatsUiState.Empty
        }
    }

    fun clear() {
        clearViewModel.clear(this::class.java)
    }

}
