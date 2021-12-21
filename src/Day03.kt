fun main() {
    fun part1(input: List<String>): Int {
        val fold = input.fold(ArrayList<Int>()) { acc, line ->
            for ((index, char) in line.withIndex()) {
                if (acc.size == index)
                    acc.add(0)
                if (char.equals('1'))
                    acc.set(index, acc.get(index) + 1)
                else
                    acc.set(index, acc.get(index))
            }
            acc
        }
        var gamma = 0b0
        var epsilon = 0b0

        for (i in fold) {
            gamma = gamma shl 1
            epsilon = epsilon shl 1
            if (i > input.size / 2) {
                gamma += 1
                epsilon += 0
            } else {
                gamma += 0
                epsilon += 1
            }
        }
        return gamma * epsilon
    }

    fun finder(input: List<String>, index: Int = 0, oneChoiceCriteria: (Int, Int) -> Boolean): Int {
        val fold = input.fold(ArrayList<String>() to ArrayList<String>()) { acc, line ->
            if (line.get(index).equals('1'))
                acc.first.add(line)
            else
                acc.second.add(line)
            acc
        }
        if (oneChoiceCriteria(fold.first.size, fold.second.size))
            return if (fold.first.size > 1) finder(fold.first, index + 1, oneChoiceCriteria) else Integer.parseInt(fold.first.get(0), 2)
        else
            return if (fold.second.size > 1) finder(fold.second, index + 1, oneChoiceCriteria) else Integer.parseInt(fold.second.get(0), 2)
    }

    fun part2(input: List<String>): Int {
        return finder(input) { oneCount, zeroCount -> oneCount >= zeroCount } * finder(input) { oneCount, zeroCount -> oneCount < zeroCount }
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    println(part1(testInput))
    check(part1(testInput) == 198)
    val input = readInput("Day03")
    println(part1(input))
    println(part2(testInput))
    check(part2(testInput) == 230)
    println(part2(input))
}
