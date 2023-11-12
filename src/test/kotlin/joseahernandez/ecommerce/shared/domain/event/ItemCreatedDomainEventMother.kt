package joseahernandez.ecommerce.shared.domain.event

import joseahernandez.ecommerce.shared.domain.event.warehouse.ItemCreatedDomainEvent
import joseahernandez.ecommerce.warehouse.domain.item.Item

class ItemCreatedDomainEventMother {
    companion object {
        fun fromItem(item: Item) =
            ItemCreatedDomainEvent(
                item.id.value,
                item.name.value,
                item.description.value,
                item.price.value,
                item.size?.length,
                item.size?.width,
                item.size?.height,
                item.weight?.value,
            )
    }
}
