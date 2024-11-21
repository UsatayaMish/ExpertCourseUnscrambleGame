package com.usatayamish.expertcourseunscramblegame.di

interface Module<T: MyViewModel> {

    fun viewModel(): T
}

