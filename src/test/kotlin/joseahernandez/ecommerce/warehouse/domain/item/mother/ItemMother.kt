package joseahernandez.ecommerce.warehouse.domain.item.mother

import joseahernandez.ecommerce.warehouse.domain.item.Description
import joseahernandez.ecommerce.warehouse.domain.item.Item
import joseahernandez.ecommerce.warehouse.domain.item.ItemId
import joseahernandez.ecommerce.warehouse.domain.item.ItemName
import joseahernandez.ecommerce.warehouse.domain.item.Price
import joseahernandez.ecommerce.warehouse.domain.item.Size
import joseahernandez.ecommerce.warehouse.domain.item.Weight

class ItemMother {
    companion object {
        fun create(
            id: ItemId = ItemIdMother.create(),
            name: ItemName = ItemNameMother.create(),
            description: Description = DescriptionMother.create(),
            price: Price = PriceMother.create(),
            size: Size? = SizeMother.create(),
            weight: Weight? = WeightMother.create(),
        ) = Item(id, name, description, price, size, weight)
    }
}
