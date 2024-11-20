package com.usatayamish.expertcourseunscramblegame

import android.app.Application
import com.usatayamish.expertcourseunscramblegame.game.GameRepository
import com.usatayamish.expertcourseunscramblegame.game.GameViewModel
import com.usatayamish.expertcourseunscramblegame.game.IntCache
import com.usatayamish.expertcourseunscramblegame.game.ShuffleStrategy
import com.usatayamish.expertcourseunscramblegame.game.StringCache

class UnscrambleApp : Application() {

    lateinit var statsViewModel: StatsViewModel
    lateinit var viewModel: GameViewModel

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = getSharedPreferences("UnscrambleData", MODE_PRIVATE)
        viewModel = GameViewModel(GameRepository.Base(
            IntCache.Base(sharedPreferences, "indexKey", 0),
            StringCache.Base(sharedPreferences, "userInputKey", ""),
            ShuffleStrategy.Reverse()
            )
        )
    }

}