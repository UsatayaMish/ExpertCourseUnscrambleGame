package com.usatayamish.expertcourseunscramblegame.di

import com.usatayamish.expertcourseunscramblegame.game.di.ProvideGameViewModel
import com.usatayamish.expertcourseunscramblegame.stats.di.ProvideStatsViewModel

interface ProvideViewModel {

    fun <T: MyViewModel> makeViewModel(clasz: Class<T>): T

    class Make(
        core: Core
    ) : ProvideViewModel {

        private var chain: ProvideViewModel

        init {
            chain = Error()
            chain = ProvideGameViewModel(core, chain)
            chain = ProvideStatsViewModel(core, chain)
        }

        override fun <T : MyViewModel> makeViewModel(clasz: Class<T>): T {
            return chain.makeViewModel(clasz)
        }
    }

    class Error: ProvideViewModel {

        override fun <T : MyViewModel> makeViewModel(clasz: Class<T>): T {
            throw IllegalStateException("unknown class $clasz")
        }
    }
}