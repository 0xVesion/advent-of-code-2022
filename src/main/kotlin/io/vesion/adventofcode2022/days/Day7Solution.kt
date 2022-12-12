package io.vesion.adventofcode2022.days

import io.vesion.adventofcode2022.lib.DaySolution

class Day7Solution : DaySolution {
    override fun solveProblemOne(input: String): Int = mutableListOf<Directory>().also { dirs ->
        Parser
            .parse(input)
            .walk {
                if (it is Directory && it.size() < 100000) {
                    dirs.add(it)
                }
            }
    }.sumOf { it.size() }

    override fun solveProblemTwo(input: String): Int = mutableListOf<Directory>().also { dirs ->
        val fs = Parser.parse(input)
        val minToDelete = 30000000 - (70000000 - fs.size())

        fs
            .walk {
                if (it is Directory && it.size() > minToDelete) {
                    dirs.add(it)
                }
            }
    }.minOf { it.size() }
}

class Parser(private val lines: List<String>, private var i: Int = 1) {
    companion object {
        fun parse(input: String): Directory = Parser(input.split("\n")).parse()
    }


    private fun hasLines() = i < lines.size

    private fun parse(parent: Directory = Directory("/")): Directory {
        while (hasLines()) {
            val line = lines[i]

            if (line == "$ ls") {
                i++
                parent.children.addAll(parseLs())
                continue
            }

            if (line == "$ cd ..") {
                i++
                break
            }

            if (line.startsWith("$ cd")) {
                val (_, name) = line.split("$ cd ")
                i++
                parse(parent.children.first { it.name() == name } as Directory)
                continue
            }

            error("OOOOPIIE: $line")
        }


        return parent
    }

    private fun parseLs(): Collection<FileSystemEntity> {
        val children = lines
            .drop(i)
            .takeWhile { !it.startsWith("$") }
            .map {
                val (size, name) = it.split(" ")

                if (size == "dir") {
                    Directory(name)
                } else {
                    File(name, size.toInt())
                }
            }

        i += children.size

        return children
    }
}

interface FileSystemEntity {
    fun size(): Int
    fun name(): String
    fun info(): String
}

data class File(val name: String, val size: Int) : FileSystemEntity {
    override fun size() = size
    override fun name() = name
    override fun info() = "- $name (file, $size)"
}

data class Directory(
    val name: String,
    val children: MutableList<FileSystemEntity> = mutableListOf(),
) :
    FileSystemEntity {
    override fun size() = children.sumOf { it.size() }

    override fun name() = name

    override fun info() = "- $name (dir,  ${size()})\n  " +
            children
                .joinToString("\n") { it.info() }
                .split("\n")
                .joinToString("\n  ")

    fun walk(inspector: (FileSystemEntity) -> Unit) {
        inspector(this)
        children.forEach {
            when (it) {
                is Directory -> it.walk(inspector)
                else -> inspector(it)
            }
        }
    }
}
