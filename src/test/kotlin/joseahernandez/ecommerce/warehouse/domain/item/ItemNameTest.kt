package joseahernandez.ecommerce.warehouse.domain.item

import joseahernandez.ecommerce.shared.extension.randomOfLength
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ItemNameTest {
    @Test
    fun `Item name should have between 3 and 100 characters`() {
        val names = listOf(
            String.randomOfLength(3),
            String.randomOfLength(50),
            String.randomOfLength(100),
        )

        names.forEach { ItemName(it) }
    }

    @Test
    fun `Item with name length less than 3 should throw exception`() {
        val names = listOf(
            String.randomOfLength(0),
            String.randomOfLength(1),
            String.randomOfLength(2),
        )

        names.forEach {
            Assertions.assertThrows(InvalidItemNameException::class.java) {
                ItemName(it)
            }
        }
    }

    @Test
    fun `Item with name length greater than 100 should throw exception`() {
        val names = listOf(
            String.randomOfLength(101),
            String.randomOfLength(120),
            String.randomOfLength(300),
        )

        names.forEach {
            Assertions.assertThrows(InvalidItemNameException::class.java) {
                ItemName(it)
            }
        }
    }
}
