package io.vesion.adventofcode2022.days

import io.vesion.adventofcode2022.lib.DaySolution

class Day5Solution : DaySolution {
    override fun solveProblemOne(input: String): String {
        val (stacks, moves) = parse(input)

        moves.forEach { (amount, from, to) ->
            repeat(amount) {
                stacks[to - 1].add(stacks[from - 1].removeLast())
            }
        }

        return stacks
            .mapNotNull { it.lastOrNull() }
            .toCharArray()
            .let { String(it) }
    }

    override fun solveProblemTwo(input: String): String {
        val (stacks, moves) = parse(input)

        moves.forEach { (amount, from, to) ->
            val fromStack = stacks[from - 1]
            val itemsToMove = fromStack.subList(fromStack.size - amount, fromStack.size)

            stacks[to - 1].addAll(itemsToMove)
            itemsToMove.clear()
        }


        return stacks
            .mapNotNull { it.lastOrNull() }
            .toCharArray()
            .let { String(it) }
    }

    companion object {
        fun parse(input: String): Pair<List<MutableList<Char>>, List<Triple<Int, Int, Int>>> {
            val lines = input.split("\n").filter { it.isNotEmpty() }
            val stacks = parseStacks(lines.filter { it.trim().startsWith("[") }.reversed())
            val moves = parseMoves(lines.filter { it.startsWith("move") })

            return stacks to moves
        }

        private fun parseStacks(lines: List<String>): List<MutableList<Char>> {
            val count = (lines.maxOf { it.length } + 1) / 4
            val stacks = (0 until count).map { mutableListOf<Char>() }

            lines.map { it.trimEnd() }.forEach {
                (0 until count).forEach { cell ->
                    val contentI = cell * 4 + 1

                    if (contentI > it.length) {
                        return@forEach
                    }

                    val content = it[contentI]
                    if (content.isLetter()) {
                        stacks[cell].add(content)
                    }
                }
            }

            return stacks
        }

        private fun parseMoves(moves: List<String>): List<Triple<Int, Int, Int>> = moves.map {
            fun readIntAfter(delimiter: String) = it
                .split("$delimiter ")[1]
                .split(" ")[0]
                .toInt()

            Triple(
                readIntAfter("move"),
                readIntAfter("from"),
                readIntAfter("to"),
            )
        }
    }
}