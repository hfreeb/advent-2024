package com.hfreeb.advent.day2

import com.hfreeb.advent.ints
import kotlin.math.abs

fun isSafe(line: List<Int>): Boolean {
    var isSafe = true

    var last = line[0]
    val direction = (line[1] - line[0]) > 0

    for (num in line.subList(1, line.size)) {
        val diff = num - last
        if (diff < 0 && direction || diff > 0 && !direction || diff == 0 || abs(diff) > 3) {
            isSafe = false
        }

        last = num
    }

    return isSafe
}

fun part1(input: List<List<Int>>): Int {
    var safe = 0

    for (line in input) {
        if (isSafe(line)) {
            safe += 1
        }
    }

    return safe
}

fun part2(input: List<List<Int>>): Int {
    var safe = 0

    for (line in input) {
        if (isSafe(line)) {
            safe += 1
            continue
        }

        for (i in line.indices) {
            val subList = line.subList(0, i) + line.subList(i + 1, line.size)
            if (isSafe(subList)) {
                safe += 1
                break
            }
        }
    }

    return safe
}

fun main() {
    val input = ClassLoader.getSystemResource("day2.txt")
        .readText()
        .trim()
        .split("\n")
        .map(::ints)

    println("part 1 = ${part1(input)}")
    println("part 2 = ${part2(input)}")
}
