package io.vesion.adventofcode2022.lib

object Utils {
    fun readResource(path: String) = javaClass.getResource(path)?.readText()!!
}