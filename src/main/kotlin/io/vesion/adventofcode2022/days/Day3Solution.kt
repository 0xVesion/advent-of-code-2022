package io.vesion.adventofcode2022.days

import io.vesion.adventofcode2022.lib.DaySolution


class Day3Solution : DaySolution {
    override fun solveProblemOne(input: String): Int =
        input.split("\n").sumOf { rucksack ->
            val compartmentA = Item.readSet(rucksack.substring(0, rucksack.length / 2))
            val compartmentB = Item.readSet(rucksack.substring(rucksack.length / 2, rucksack.length))

            (compartmentA intersect compartmentB).first().priority()
        }

    override fun solveProblemTwo(input: String): Int {
        val rucksacks = input
            .split("\n")
            .map(Item::readSet)

        return (0..rucksacks.size - 3 step 3).sumOf {
            val a = rucksacks[it]
            val b = rucksacks[it + 1]
            val c = rucksacks[it + 2]

            (a intersect b intersect c).first().priority()
        }
    }
}

data class Item(val name: Char) {
    companion object {
        fun readSet(s: String) = s.split("")
            .filter { it.isNotEmpty() }
            .map { Item(it.toCharArray().first()) }
            .toSet()
    }

    fun priority(): Int {
        val v = (name.lowercaseChar() - 'a') + 1

        return if (name.isUpperCase()) v + 26 else v
    }
}