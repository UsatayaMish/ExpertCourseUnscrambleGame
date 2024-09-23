package com.usatayamish.expertcourseunscramblegame

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


class GameViewModelTest {

    private lateinit var viewModel: GameViewModel

    @Before
    fun setup() {
        viewModel = GameViewModel(repository = FakeRepository())
    }

    /**
     * UGTC-01
     *
     */
    @Test
    fun caseNumber1() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f1")
        expected = GameUiState.Sufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "1f")
        expected = GameUiState.Correct(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = GameUiState.Initial(shuffledWord = "f2")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-02
     *
     */
    @Test
    fun caseNumber2() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f")
        expected = GameUiState.Insufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f1")
        expected = GameUiState.Sufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "1f")
        expected = GameUiState.Correct(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = GameUiState.Initial(shuffledWord = "f2")
        assertEquals(expected, actual)
    }


    /**
     * UGTC-03
     */
    @Test
    fun caseNumber3() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "f2")
        assertEquals(expected, actual)

    }

    /**
     * UGTC-04
     */
    @Test
    fun caseNumber4() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f")
        expected = GameUiState.Insufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "f2")
        assertEquals(expected, actual)

    }

    /**
     * UGTC-05
     */
    @Test
    fun caseNumber5() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f")
        expected = GameUiState.Insufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f1")
        expected = GameUiState.Sufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "f2")
        assertEquals(expected, actual)

    }

    /**
     * UGTC-06
     */
    @Test
    fun caseNumber6() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f")
        expected = GameUiState.Insufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f1")
        expected = GameUiState.Sufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f")
        expected = GameUiState.Insufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "f2")
        assertEquals(expected, actual)

    }

    /**
     * UGTC-07
     */
    @Test
    fun caseNumber7() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f")
        expected = GameUiState.Insufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f0")
        expected = GameUiState.Sufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "f0")
        expected = GameUiState.Incorrect(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "f2")
        assertEquals(expected, actual)

    }

    /**
     * UGTC-08
     */
    @Test
    fun caseNumber8() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f")
        expected = GameUiState.Insufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f0")
        expected = GameUiState.Sufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "f0")
        expected = GameUiState.Incorrect(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f1")
        expected = GameUiState.Sufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "f2")
        assertEquals(expected, actual)

    }

    /**
     * UGTC-09
     */
    @Test
    fun caseNumber9() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f")
        expected = GameUiState.Insufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f0")
        expected = GameUiState.Sufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "f0")
        expected = GameUiState.Incorrect(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f")
        expected = GameUiState.Insufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "f2")
        assertEquals(expected, actual)

    }

    /**
     * UGTC-10
     */
    @Test
    fun caseNumber10() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f")
        expected = GameUiState.Insufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f0")
        expected = GameUiState.Sufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "f0")
        expected = GameUiState.Incorrect(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f1")
        expected = GameUiState.Sufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "1f")
        expected = GameUiState.Correct(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = GameUiState.Initial(shuffledWord = "f2")
        assertEquals(expected, actual)

    }

    /**
     * UGTC-11
     */
    @Test
    fun caseNumber11() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f")
        expected = GameUiState.Insufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f0")
        expected = GameUiState.Sufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "f0")
        expected = GameUiState.Incorrect(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f")
        expected = GameUiState.Insufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "f1")
        expected = GameUiState.Sufficient(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "1f")
        expected = GameUiState.Correct(shuffledWord = "f1")
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = GameUiState.Initial(shuffledWord = "f2")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "f3")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "f4")
        assertEquals(expected, actual)
    }



}

private class FakeRepository : GameRepository {

    private val originalList = listOf(
        "1f", "2f", "3f", "4f", "5f", "6f"
    )

    private val shuffledList = originalList.map {
        it.reversed()
    }

    private var index = 0

    override fun shuffledWord() : String = shuffledList[index]

    override fun originalWord() : String = originalList[index]

    override fun next() {
        index++
        if (index == originalList.size)
            index = 0
    }
}