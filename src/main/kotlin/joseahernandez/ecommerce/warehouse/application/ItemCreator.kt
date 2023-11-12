package joseahernandez.ecommerce.warehouse.application

import jakarta.inject.Singleton
import joseahernandez.ecommerce.shared.domain.event.EventBus
import joseahernandez.ecommerce.warehouse.domain.item.Description
import joseahernandez.ecommerce.warehouse.domain.item.ItemDuplicationException
import joseahernandez.ecommerce.warehouse.domain.item.ItemId
import joseahernandez.ecommerce.warehouse.domain.item.ItemName
import joseahernandez.ecommerce.warehouse.domain.item.ItemRepository
import joseahernandez.ecommerce.warehouse.domain.item.Price
import joseahernandez.ecommerce.warehouse.domain.item.Size
import joseahernandez.ecommerce.warehouse.domain.item.Weight
import joseahernandez.ecommerce.warehouse.domain.warehouse.InvalidWarehouseIdException
import joseahernandez.ecommerce.warehouse.domain.warehouse.Warehouse
import joseahernandez.ecommerce.warehouse.domain.warehouse.WarehouseId
import kotlin.jvm.optionals.getOrElse

@Singleton
class ItemCreator(
    private val warehouseFinder: WarehouseFinder,
    private val itemFinder: ItemFinder,
    private val itemRepository: ItemRepository,
    private val eventBus: EventBus,
) {
    fun execute(
        warehouseId: WarehouseId,
        itemId: ItemId,
        name: ItemName,
        description: Description,
        price: Price,
        size: Size? = null,
        weight: Weight? = null,
    ) {
        assertItemDoesNotExists(itemId)
        val warehouse = getWarehouse(warehouseId)

        val item = warehouse.createItem(itemId, name, description, price, size, weight)
        itemRepository.save(item)

        eventBus.publish(warehouse.pullDomainEvents())
    }

    private fun assertItemDoesNotExists(itemId: ItemId) {
        if (itemFinder.run(itemId).isPresent) {
            throw ItemDuplicationException("The item ${itemId.value} exists and can't be created again")
        }
    }

    private fun getWarehouse(warehouseId: WarehouseId): Warehouse =
        warehouseFinder.run(warehouseId)
            .getOrElse { throw InvalidWarehouseIdException("Warehouse ${warehouseId.value} doesn't exists") }
}
