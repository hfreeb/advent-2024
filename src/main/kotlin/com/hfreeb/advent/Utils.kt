package com.hfreeb.advent

fun ints(line: String): List<Int> {
    if ("""\d-\d""".toRegex().find(line) != null) {
        throw IllegalArgumentException("Matching \\d-\\d")
    }

    return """-?\d+""".toRegex().findAll(line).map { it.value.toInt() }.toList()
}
