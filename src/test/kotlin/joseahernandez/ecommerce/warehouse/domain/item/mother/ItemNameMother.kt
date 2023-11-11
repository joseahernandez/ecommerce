package joseahernandez.ecommerce.warehouse.domain.item.mother

import joseahernandez.ecommerce.shared.DataFaker
import joseahernandez.ecommerce.warehouse.domain.item.ItemName

class ItemNameMother : DataFaker() {
    companion object {
        fun create(name: String = faker.commerce().productName()) = ItemName(name)
    }
}
