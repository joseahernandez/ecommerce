package joseahernandez.ecommerce.warehouse.domain.item.mother

import joseahernandez.ecommerce.shared.DataFaker
import joseahernandez.ecommerce.warehouse.domain.item.Price
import java.math.BigDecimal

class PriceMother : DataFaker() {
    companion object {
        fun create(price: BigDecimal = faker.commerce().price().toBigDecimal()) = Price(price)
    }
}
