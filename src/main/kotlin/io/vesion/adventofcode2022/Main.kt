package io.vesion.adventofcode2022

import io.vesion.adventofcode2022.lib.Utils
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required
import java.io.File

fun main(args: Array<String>) {
    val parser = ArgParser("Advent Of Code 2022 Solutions by 0xVesion")

    val day by parser.option(ArgType.Int, fullName = "day", shortName = "d", description = "Day").required()
    val inputFile by parser.option(ArgType.String, fullName = "input", shortName = "i", description = "Input file")

    parser.parse(args)

    if (day < 1 || day > solutions.size) {
        throw RuntimeException("Invalid day")
    }
    val solution = solutions[day - 1]

    val input = if (inputFile == null) {
        Utils.readResource("/example-inputs/day$day.txt")
    } else {
        File(inputFile!!).readText()
    }

    println("---------------")
    println("Day $day")
    println("Solution One: ${solution.solveProblemOne(input)}")
    println("Solution Two: ${solution.solveProblemTwo(input)}")
    println("---------------")
}