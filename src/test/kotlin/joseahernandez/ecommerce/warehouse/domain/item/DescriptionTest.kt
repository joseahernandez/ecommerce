package joseahernandez.ecommerce.warehouse.domain.item

import joseahernandez.ecommerce.shared.extension.randomOfLength
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DescriptionTest {

    @Test
    fun `Item description should have between 0 and 5_000 characters`() {
        val descriptions = listOf(
            String.randomOfLength(0),
            String.randomOfLength(1_500),
            String.randomOfLength(5_000),
        )

        descriptions.forEach { Description(it) }
    }

    @Test
    fun `Item with description length greater than 5_000 should throw exception`() {
        val names = listOf(
            String.randomOfLength(5_001),
            String.randomOfLength(6_000),
        )

        names.forEach {
            Assertions.assertThrows(InvalidItemDescriptionException::class.java) {
                Description(it)
            }
        }
    }
}
