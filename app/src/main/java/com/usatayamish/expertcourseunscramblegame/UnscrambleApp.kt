package com.usatayamish.expertcourseunscramblegame

import android.app.Application

class UnscrambleApp : Application() {

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