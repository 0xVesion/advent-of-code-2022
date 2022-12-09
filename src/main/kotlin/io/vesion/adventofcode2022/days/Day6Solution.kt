package io.vesion.adventofcode2022.days

import io.vesion.adventofcode2022.lib.DaySolution

class Day6Solution : DaySolution {
    override fun solveProblemOne(input: String): Int = findMarker(input, 4)

    override fun solveProblemTwo(input: String): Int = findMarker(input, 14)

    companion object {
        private fun findMarker(input: String, size: Int): Int {
            for (i in size..input.length) {
                if (input.subSequence(i - size, i).toSet().size == size) {
                    return i
                }
            }

            error("couldn't find marker")
        }
    }
}