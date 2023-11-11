package joseahernandez.ecommerce.warehouse.application

import jakarta.inject.Singleton
import joseahernandez.ecommerce.warehouse.domain.item.Item
import joseahernandez.ecommerce.warehouse.domain.item.ItemId
import joseahernandez.ecommerce.warehouse.domain.item.ItemRepository
import java.util.Optional

@Singleton
class ItemFinder(private val repository: ItemRepository) {
    fun run(itemId: ItemId): Optional<Item> =
        repository.findById(itemId)
}
