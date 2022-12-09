package io.vesion.adventofcode2022.days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day5SolutionTest {
    private val stacksTemplate = """
    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 
"""

    @Test
    fun `should parse properly`() {
        val input = """$stacksTemplate
move 1 from 2 to 1
move 13 from 13 to 31
move 2 from 2 to 1
move 1 from 1 to 2
        """.trimIndent()
        val (stacks, moves) = Day5Solution.parse(input)

        assertEquals(
            listOf(
                listOf('Z', 'N'),
                listOf('M', 'C', 'D'),
                listOf('P')
            ),
            stacks
        )
        assertEquals(
            listOf(
                Triple(1, 2, 1),
                Triple(13, 13, 31),
                Triple(2, 2, 1),
                Triple(1, 1, 2)
            ),
            moves
        )
    }

    @Test
    fun `solveProblemOne with no moves should return top row of letters`() {
        val input = """$stacksTemplate
        """.trimIndent()
        val result = Day5Solution().solveProblemOne(input)

        assertEquals("NDP", result)
    }

    @Test
    fun `solveProblemOne when moving one should return correct result`() {
        val input = """$stacksTemplate
move 1 from 1 to 2
        """.trimIndent()
        val result = Day5Solution().solveProblemOne(input)

        assertEquals("ZNP", result)
    }

    @Test
    fun `solveProblemOne when moving two should return correct result`() {
        val input = """$stacksTemplate
move 2 from 2 to 3
        """.trimIndent()
        val result = Day5Solution().solveProblemOne(input)

        assertEquals("NMC", result)
    }

    @Test
    fun `solveProblemOne with empty stack should return correct result`() {
        val input = """$stacksTemplate
move 2 from 1 to 3
        """.trimIndent()
        val result = Day5Solution().solveProblemOne(input)

        assertEquals("DZ", result)
    }
}