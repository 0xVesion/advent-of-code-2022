package io.vesion.adventofcode2022.days

import io.vesion.adventofcode2022.lib.DaySolution


class Day2Solution : DaySolution {
    override fun solveProblemOne(input: String): Int {
        return input
            .split("\n")
            .map { it.split(" ").map { s -> charToNumber(s) } }
            .sumOf { (a, b) -> calcScore(a, b) }
    }

    override fun solveProblemTwo(input: String): Int = input
        .split("\n")
        .map {
            val (ax, bb) = it.split(" ")
            val a = charToNumber(ax)

            val b = when (bb) {
                "Y" -> a
                "X" -> beatenBy(a)
                else -> beats(a)
            }


            listOf(a, b)
        }
        .sumOf { (a, b) -> calcScore(a, b) }

    private fun calcScore(a: Int, b: Int): Int = when (a) {
        b -> b + 3
        beats(b) -> b + 6
        else -> b
    }

    private fun beats(a: Int): Int = (a + 1) % 3
    private fun beatenBy(a: Int): Int = ((a - 1) % 4 + 4) % 4
}

fun charToNumber(c: String): Int = (c.toCharArray().first().lowercaseChar() - 'a') % 23 + 1
