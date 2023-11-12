package joseahernandez.ecommerce.warehouse.domain.warehouse

import joseahernandez.ecommerce.shared.domain.AggregateRoot
import joseahernandez.ecommerce.shared.domain.event.warehouse.ItemCreatedDomainEvent
import joseahernandez.ecommerce.warehouse.domain.item.Description
import joseahernandez.ecommerce.warehouse.domain.item.Item
import joseahernandez.ecommerce.warehouse.domain.item.ItemId
import joseahernandez.ecommerce.warehouse.domain.item.ItemName
import joseahernandez.ecommerce.warehouse.domain.item.Price
import joseahernandez.ecommerce.warehouse.domain.item.Size
import joseahernandez.ecommerce.warehouse.domain.item.Weight

class Warehouse(
    val id: WarehouseId,
    val name: WarehouseName,
    val address: Address,
) : AggregateRoot() {

    fun createItem(
        id: ItemId,
        name: ItemName,
        description: Description,
        price: Price,
        size: Size? = null,
        weight: Weight? = null,
    ): Item {
        val item = Item(
            id,
            name,
            description,
            price,
            size,
            weight,
        )

        record(
            ItemCreatedDomainEvent(
                item.id.value,
                name.value,
                description.value,
                price.value,
                size?.length,
                size?.width,
                size?.height,
                weight?.value,
            ),
        )

        return item
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Warehouse

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
