package com.usatayamish.expertcourseunscramblegame

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

        actualState = StatsUiState.Empty

        assertEquals(StatsUiState.Empty, actualState)

        viewModel.clear()
        repository.assertClearCalled()
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