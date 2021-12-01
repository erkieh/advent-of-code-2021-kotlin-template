import java.util.*

fun main() {
    fun part1(input: List<String>): Int {
        if (input.size < 2)
            return 0
        var count = 0
        input.map(Integer::parseInt).reduce { acc, i ->
            if (i > acc)
                count++
            i
        }
        return count
    }

    fun part2(input: List<String>): Int {
        if (input.size < 4)
            return 0
        val ints = input.map(Integer::parseInt)
        val window = LinkedList(ints.subList(0, 3))
        var count = 0
        var previousSum = window.sum()
        ints.subList(3, ints.size).forEach { depth: Int ->
            val currentSum = with(window) {
                remove()
                add(depth)
                sum()
            }
            if (currentSum > previousSum)
                count++
            previousSum = currentSum
        }
        return count
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")


    println(part1(input))
    println(part2(input))
}
