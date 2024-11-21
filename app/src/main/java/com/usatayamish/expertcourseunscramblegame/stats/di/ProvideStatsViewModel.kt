package com.usatayamish.expertcourseunscramblegame.stats.di

import com.usatayamish.expertcourseunscramblegame.di.AbstractProvideViewModel
import com.usatayamish.expertcourseunscramblegame.di.Core
import com.usatayamish.expertcourseunscramblegame.di.Module
import com.usatayamish.expertcourseunscramblegame.di.ProvideViewModel
import com.usatayamish.expertcourseunscramblegame.stats.StatsRepository
import com.usatayamish.expertcourseunscramblegame.stats.StatsViewModel

class ProvideStatsViewModel(
    core: Core,
    next: ProvideViewModel
): AbstractProvideViewModel(
    core,
    next,
    StatsViewModel::class.java
) {
    override fun module(): Module<*> = StatsModule(core)
}

class StatsModule(private val core: Core): Module<StatsViewModel> {

    override fun viewModel(): StatsViewModel {
        return StatsViewModel(
            StatsRepository.Base(
                core.statsCache
            ),
            core.clearViewModel
        )
    }


}