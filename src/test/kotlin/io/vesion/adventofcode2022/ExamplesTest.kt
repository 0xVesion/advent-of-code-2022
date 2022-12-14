package io.vesion.adventofcode2022

import io.vesion.adventofcode2022.lib.Utils
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ExamplesTest {
    @Test
    fun `should solve all examples`() {
        solutions.forEachIndexed { i, solution ->
            val day = i + 1
            val input = getExampleInput(day)
            val (expectedOne, expectedTwo) = getExpectedSolutions(day)

            val resultOne = solution.solveProblemOne(input)
            assertEquals(expectedOne, resultOne.toString(), "Day $day solution 1")

            val resultTwo = solution.solveProblemTwo(input)
            assertEquals(expectedTwo, resultTwo.toString(), "Day $day solution 2")
        }
    }

    private fun getExampleInput(day: Int) = Utils.readResource("/example-inputs/day$day.txt")

    private fun getExpectedSolutions(day: Int) =
        Utils.readResource("/example-solutions.txt")
            .split("\n")[day - 1]
            .split(" ")
}
