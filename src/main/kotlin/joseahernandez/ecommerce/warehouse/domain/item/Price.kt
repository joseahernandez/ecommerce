package joseahernandez.ecommerce.warehouse.domain.item

import java.math.BigDecimal

data class Price(val value: BigDecimal) {

    init {
        if (value <= BigDecimal.ZERO) {
            throw InvalidItemPriceException("Item price should be greater than 0.0")
        }
    }
}
