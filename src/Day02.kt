fun main() {
    fun part1(input: List<String>): Int {
        val fold = input.fold(0 to 0) { acc, line ->
            val strings = line.split(" ")
            val value = strings[1].toInt()
            if (strings[0].equals("forward"))
                acc.first + value to acc.second
            else if (strings[0].equals("down"))
                acc.first to acc.second + value
            else
                acc.first to acc.second - value
        }
        return fold.first * fold.second
    }

    fun part2(input: List<String>): Int {
        val fold = input.fold(Triple(0, 0, 0)) { acc, line ->
            val strings = line.split(" ")
            val value = strings[1].toInt()
            if (strings[0].equals("forward"))
                Triple(acc.first,  acc.second + value,  acc.third + acc.first * value)
            else if (strings[0].equals("down"))
                Triple(acc.first + value,  acc.second,  acc.third)
            else
                Triple(acc.first - value,  acc.second,  acc.third)
        }
        return fold.second * fold.third
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")


    println(part1(input))
    println(part2(input))
}
