package com.usatayamish.expertcourseunscramblegame.di

import android.app.Application.MODE_PRIVATE
import android.content.Context
import android.content.SharedPreferences
import com.usatayamish.expertcourseunscramblegame.R
import com.usatayamish.expertcourseunscramblegame.stats.StatsCache

class Core(context: Context, val clearViewModel: ClearViewModel) {

    val sharedPreferences: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), MODE_PRIVATE)

    val statsCache: StatsCache.All = StatsCache.Base(sharedPreferences)
}