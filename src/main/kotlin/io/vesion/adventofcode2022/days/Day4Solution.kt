package io.vesion.adventofcode2022.days

import io.vesion.adventofcode2022.lib.DaySolution

class Day4Solution : DaySolution {
    override fun solveProblemOne(input: String): Int = parseRanges(input)
        .count { (a, b) ->
            a.contains(b.first) && a.contains(b.last) || b.contains(a.first) && b.contains(a.last)
        }

    override fun solveProblemTwo(input: String): Int = parseRanges(input)
        .count { (a, b) ->
            a.contains(b.first) || a.contains(b.last) || b.contains(a.first) || b.contains(a.last)
        }
}

fun parseRanges(input: String): List<Pair<IntRange, IntRange>> = input
    .split("\n")
    .map {
        val ranges = it
            .split(",")
            .map { rangeStr ->
                val ids = rangeStr.split("-").map(String::toInt)
                ids[0]..ids[1]
            }

        ranges[0] to ranges[1]
    }