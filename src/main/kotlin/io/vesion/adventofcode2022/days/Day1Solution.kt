package io.vesion.adventofcode2022.days

import io.vesion.adventofcode2022.lib.DaySolution

class Day1Solution : DaySolution {
    override fun solveProblemOne(input: String): Int = input
        .split("\n\n")
        .maxOf {
            it
                .split("\n")
                .sumOf { s -> s.toInt() }
        }

    override fun solveProblemTwo(input: String): Int = input
        .split("\n\n")
        .map {
            it
                .split("\n")
                .sumOf { s -> s.toInt() }
        }
        .sortedDescending()
        .take(3)
        .sum()
}