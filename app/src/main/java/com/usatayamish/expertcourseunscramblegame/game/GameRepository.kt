package com.usatayamish.expertcourseunscramblegame.game

import com.usatayamish.expertcourseunscramblegame.stats.StatsCache
import kotlin.streams.toList

interface GameRepository {

    fun shuffledWord(): String

    fun isCorrect(text: String): Boolean

    fun next()

    fun skip()

    fun saveUserInput(value: String)

    fun userInput(): String

    fun isLastWord(): Boolean


    class Base(
        private val statsCache: StatsCache.Game,
        private val index: IntCache,
        private val userInput: StringCache,
        private val shuffleStrategy: ShuffleStrategy = ShuffleStrategy.Reverse(),
        private val originalList: List<String> = listOf(
            "animal",
            "auto",
            "anecdote",
            "alphabet",
            "all"
        )
    ) : GameRepository {

        private val shuffledList = originalList.map {
            shuffleStrategy.shuffle(it)
        }

        override fun shuffledWord(): String = shuffledList[index.read()]

        override fun isCorrect(text: String): Boolean {
            val isCorrect =  originalList[index.read()].equals(text, ignoreCase = true)
            if (isCorrect)
                statsCache.incrementCorrects()
            else
                statsCache.incrementSkips()
            return isCorrect
        }


        override fun next() {
            index.save(index.read() + 1)
            userInput.save("")

        }

        override fun skip() {
            statsCache.incrementSkips()
            next()
        }

        override fun saveUserInput(value: String) {
            userInput.save(value)
        }

        override fun userInput(): String {
            return userInput.read()
        }

        override fun isLastWord(): Boolean {
            val isLastWord = index.read() == originalList.size
            if (isLastWord)
                index.save(0)
            return isLastWord
        }
    }
}

interface ShuffleStrategy {

    fun shuffle(source: String): String

    class Base : ShuffleStrategy {

        override fun shuffle(source: String): String {
            return source.chars().toList().shuffled().toString()
        }
    }

    class Reverse : ShuffleStrategy {

        override fun shuffle(source: String): String {
            return source.reversed()
        }
    }
}
