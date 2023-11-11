package joseahernandez.ecommerce.warehouse.infrastructure.repository

import jakarta.inject.Singleton
import joseahernandez.ecommerce.warehouse.domain.item.Item
import joseahernandez.ecommerce.warehouse.domain.item.ItemId
import joseahernandez.ecommerce.warehouse.domain.item.ItemRepository
import java.util.Optional

@Singleton
class MemoryItemRepository : ItemRepository {
    private val items: MutableMap<ItemId, Item> = mutableMapOf()

    override fun findById(id: ItemId): Optional<Item> {
        return if (items.containsKey(id)) {
            Optional.of(items.getValue(id))
        } else {
            Optional.empty()
        }
    }

    override fun save(item: Item) {
        items[item.id] = item
    }

    fun clear() = items.clear()
}
