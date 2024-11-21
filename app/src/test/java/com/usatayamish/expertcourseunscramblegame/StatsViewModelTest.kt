package com.usatayamish.expertcourseunscramblegame

import com.usatayamish.expertcourseunscramblegame.stats.StatsRepository
import com.usatayamish.expertcourseunscramblegame.stats.StatsViewModel
import com.usatayamish.expertcourseunscramblegame.views.stats.StatsUiState
import org.junit.Assert.assertEquals
import org.junit.Test

class StatsViewModelTest {

    @Test
    fun test() {

        val repository = FakeStatsRepository()
        val viewModel = StatsViewModel(repository = repository)

        var actualState = viewModel.init(isFirstRun = true)
        assertEquals(StatsUiState.Base(1, 2, 3), actualState)
        repository.assertClearCalled()

        actualState = StatsUiState.Empty
        assertEquals(StatsUiState.Empty, actualState)

    }
}

private class FakeStatsRepository: StatsRepository {

    private var clearCalled: Boolean = false

    override fun stats(): Triple<Int, Int, Int> {
        return  Triple(1, 2, 3)
    }

    override fun clear() {
        clearCalled = true
    }

    fun assertClearCalled() {
        assertEquals(true, clearCalled)
    }
}