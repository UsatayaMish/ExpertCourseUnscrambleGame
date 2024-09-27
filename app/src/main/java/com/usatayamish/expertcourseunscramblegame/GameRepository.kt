package com.usatayamish.expertcourseunscramblegame

import kotlin.streams.toList

interface GameRepository {

    fun shuffledWord(): String

    fun originalWord(): String

    fun next()

    class Base(
        private val shuffleStrategy: ShuffleStrategy = ShuffleStrategy.Reverse(),
        private val originalList: List<String> = listOf(
            "animal",
            "auto",
            "anecdote"
        )
    ) : GameRepository {



        private val shuffledList = originalList.map {
            shuffleStrategy.shuffle(it)
        }

        private var index = 0

        override fun shuffledWord(): String = shuffledList[index]

        override fun originalWord(): String = originalList[index]

        override fun next() {
            index++
            if (index == originalList.size)
                index = 0

        }
    }
}

interface ShuffleStrategy {

    fun shuffle(source: String) : String

    class Base : ShuffleStrategy{

        override fun shuffle(source: String): String {
            return source.chars().toList().shuffled().toString()
        }
    }

    class Reverse : ShuffleStrategy{

        override fun shuffle(source: String): String {
            return source.reversed()
        }
    }
}
