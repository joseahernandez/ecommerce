package joseahernandez.ecommerce.warehouse.domain.item.mother

import joseahernandez.ecommerce.shared.DataFaker
import joseahernandez.ecommerce.warehouse.domain.item.Weight



class WeightMother : DataFaker() {
    companion object {
        private const val DECIMALS = 2
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 80

        fun create(value: Float? = faker.number().randomDouble(DECIMALS, MIN_VALUE, MAX_VALUE).toFloat()) =
            value?.let { Weight(value) }
    }
}
