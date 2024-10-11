package com.usatayamish.expertcourseunscramblegame

import kotlin.streams.toList

interface GameRepository {

    fun shuffledWord(): String

    fun originalWord(): String

    fun next()

    fun saveUserInput(value: String)

    fun userInput(): String

    class Base(
        private val index: IntCache,
        private val userInput: StringCache,
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

        override fun shuffledWord(): String = shuffledList[index.read()]

        override fun originalWord(): String = originalList[index.read()]

        override fun next() {
            index.save(index.read() + 1)
            if (index.read() == originalList.size)
                index.save(0)
            userInput.save("")

        }

        override fun saveUserInput(value: String) {
            userInput.save(value)
        }

        override fun userInput(): String {
            return userInput.read()
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
