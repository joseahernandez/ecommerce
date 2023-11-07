package joseahernandez.ecommerce.warehouse.domain.item

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class PriceTest {
    @Test
    fun `Price should be greater than 0`() {
        val prices = listOf(0.1, 10.3, 1_050.87)

        prices.forEach { Price(BigDecimal(it)) }
    }

    @Test
    fun `Price lower than 0 should throw exception`() {
        val prices = listOf(0.0, -50.34, -0.1)

        prices.forEach {
            Assertions.assertThrows(InvalidItemPriceException::class.java) {
                Price(BigDecimal(it))
            }
        }
    }
}
