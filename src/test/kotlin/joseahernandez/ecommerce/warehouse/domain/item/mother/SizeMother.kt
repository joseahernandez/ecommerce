package joseahernandez.ecommerce.warehouse.domain.item.mother

import joseahernandez.ecommerce.shared.DataFaker
import joseahernandez.ecommerce.warehouse.domain.item.Size

class SizeMother : DataFaker() {
    companion object {
        private const val DECIMALS = 2
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 80

        fun create(
            length: Float? = faker.number().randomDouble(DECIMALS, MIN_VALUE, MAX_VALUE).toFloat(),
            width: Float? = faker.number().randomDouble(DECIMALS, MIN_VALUE, MAX_VALUE).toFloat(),
            height: Float? = faker.number().randomDouble(DECIMALS, MIN_VALUE, MAX_VALUE).toFloat(),
        ): Size? {
            return if (length == null || width == null || height == null) {
                null
            } else {
                Size(length, width, height)
            }
        }
    }
}
