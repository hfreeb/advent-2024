package com.hfreeb.advent.day1

import com.hfreeb.advent.ints
import kotlin.math.abs

fun part1(input: List<List<Int>>): Int {
    val a = input.map { it[0] }.toMutableList()
    val b = input.map { it[1] }.toMutableList()

    a.sort()
    b.sort()

    var sum = 0
    for (i in a.indices) {
       sum += abs(a[i] - b[i])
    }

    return sum
}

fun part2(input: List<List<Int>>): Int {
    val a = input.map { it[0] }
    val b = input.map { it[1] }

    val freq = mutableMapOf<Int, Int>()
    for (x in b) {
        freq[x] = (freq[x] ?: 0) + 1
    }

    var sum = 0
    for (x in a) {
        sum += x * (freq[x] ?: 0)
    }

    return sum
}

fun main() {
    val input = ClassLoader.getSystemResource("day1.txt")
        .readText()
        .trim()
        .split("\n")
        .map(::ints)

    println("part 1 = ${part1(input)}")
    println("part 2 = ${part2(input)}")
}
