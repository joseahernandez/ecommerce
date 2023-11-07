package joseahernandez.ecommerce.shared.extension

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

fun String.Companion.randomOfLength(length: Int) =
    (1..length).map { ('A'..'Z').random() }.joinToString("")

class ExtensionString {
    @Test
    fun `randomOfLength should return a string of the length indicated`() {
        val expectedLengths = listOf(0, 5, 103, 1000)

        expectedLengths.forEach {
            Assertions.assertEquals(it, String.randomOfLength(it).length)
        }
    }
}
