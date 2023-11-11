package joseahernandez.ecommerce.warehouse.domain.item.mother

import joseahernandez.ecommerce.shared.DataFaker
import joseahernandez.ecommerce.warehouse.domain.item.Description

class DescriptionMother : DataFaker() {
    companion object {
        fun create(description: String = faker.text().text(0, 5_000)) = Description(description)
    }
}
