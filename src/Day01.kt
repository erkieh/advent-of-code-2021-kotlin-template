fun main() {
    fun part1(input: List<String>): Int {
        if (input.size < 2)
            return 0
        val ints = input.map(Integer::parseInt)
        return ints.subList(1, ints.size).fold(0 to ints.first()) { acc, i ->
            if (i > acc.second)
                acc.first + 1 to i
            else
                acc.first to i
        }.first
    }

    fun part2(input: List<String>): Int {
        if (input.size < 4)
            return 0
        val ints = input.map(Integer::parseInt)

        return (3 until ints.size).fold(0 to ints.subList(0, 3).sum()) { acc, i ->
            val sum = ints.subList(i-2, i+1).sum()
            if (sum > acc.second)
                acc.first + 1 to sum
            else
                acc.first to sum
        }.first
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")


    println(part1(input))
    println(part2(input))
}
