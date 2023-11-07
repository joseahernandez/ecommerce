package joseahernandez.ecommerce.warehouse.domain.item

import java.util.Optional

interface ItemRepository {
    fun findById(id: ItemId): Optional<Item>
    fun save(item: Item)
}
