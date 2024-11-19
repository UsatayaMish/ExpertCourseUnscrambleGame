package com.usatayamish.expertcourseunscramblegame.main

import com.usatayamish.expertcourseunscramblegame.game.GameScreen
import com.usatayamish.expertcourseunscramblegame.game.NavigateToGame
import com.usatayamish.expertcourseunscramblegame.stats.NavigateToStats
import com.usatayamish.expertcourseunscramblegame.stats.StatsScreen

interface Navigation : NavigateToGame, NavigateToStats{

    fun navigate(screen: Screen)

    override fun navigateToGame() {
        navigate(GameScreen)
    }

    override fun navigateToStats() {
        navigate(StatsScreen)
    }
}