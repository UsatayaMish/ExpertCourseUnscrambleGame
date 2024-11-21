package com.usatayamish.expertcourseunscramblegame.game.di

import com.usatayamish.expertcourseunscramblegame.di.AbstractProvideViewModel
import com.usatayamish.expertcourseunscramblegame.di.Core
import com.usatayamish.expertcourseunscramblegame.di.Module
import com.usatayamish.expertcourseunscramblegame.di.ProvideViewModel
import com.usatayamish.expertcourseunscramblegame.game.GameRepository
import com.usatayamish.expertcourseunscramblegame.game.GameViewModel
import com.usatayamish.expertcourseunscramblegame.game.IntCache
import com.usatayamish.expertcourseunscramblegame.game.ShuffleStrategy
import com.usatayamish.expertcourseunscramblegame.game.StringCache

class ProvideGameViewModel(
    core: Core,
    next: ProvideViewModel
) : AbstractProvideViewModel(
    core,
    next,
    GameViewModel::class.java
) {
    override fun module(): Module<*> = GameModule(core)
}

class GameModule(private val core: Core) : Module<GameViewModel> {

    override fun viewModel(): GameViewModel {
        return GameViewModel(
            GameRepository.Base(
                core.statsCache,
                IntCache.Base(core.sharedPreferences, "indexKey", 0),
                StringCache.Base(core.sharedPreferences, "userInputKey", ""),
                ShuffleStrategy.Reverse()
            ),
            core.clearViewModel
        )
    }
}