package io.vesion.adventofcode2022.days

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day6SolutionTest {
    @Test
    fun solveProblemOne() {
        mapOf(
            "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 7,
            "bvwbjplbgvbhsrlpgdmjqwftvncz" to 5,
            "nppdvjthqldpwncqszvftbrmjlhg" to 6,
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 10,
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 11,
        ).forEach { (input, expected) ->
            val result = Day6Solution().solveProblemOne(input)
            assertEquals(expected, result, input)
        }
    }
    @Test
    fun solveProblemTwo() {
        mapOf(
            "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 19,
            "bvwbjplbgvbhsrlpgdmjqwftvncz" to 23,
            "nppdvjthqldpwncqszvftbrmjlhg" to 23,
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 29,
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 26,
        ).forEach { (input, expected) ->
            val result = Day6Solution().solveProblemTwo(input)
            assertEquals(expected, result, input)
        }
    }
}