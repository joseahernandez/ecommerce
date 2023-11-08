package joseahernandez.ecommerce.warehouse.domain.warehouse

import joseahernandez.ecommerce.shared.extension.randomOfLength
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WarehouseNameTest {
    @Test
    fun `Warehouse name should have between 3 and 50 characters`() {
        val names = listOf(
            String.randomOfLength(3),
            String.randomOfLength(16),
            String.randomOfLength(50),
        )

        names.forEach { WarehouseName(it) }
    }

    @Test
    fun `Warehouse with name length less than 3 should throw exception`() {
        val names = listOf(
            String.randomOfLength(0),
            String.randomOfLength(1),
            String.randomOfLength(2),
        )

        names.forEach {
            Assertions.assertThrows(InvalidWarehouseNameException::class.java) {
                WarehouseName(it)
            }
        }
    }

    @Test
    fun `Warehouse with name length greater than 50 should throw exception`() {
        val names = listOf(
            String.randomOfLength(51),
            String.randomOfLength(60),
            String.randomOfLength(200),
        )

        names.forEach {
            Assertions.assertThrows(InvalidWarehouseNameException::class.java) {
                WarehouseName(it)
            }
        }
    }
}
