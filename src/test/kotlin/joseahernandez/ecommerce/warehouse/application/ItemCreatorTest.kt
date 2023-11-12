package joseahernandez.ecommerce.warehouse.application

import io.mockk.clearMocks
import io.mockk.mockk
import io.mockk.verify
import java.util.UUID
import joseahernandez.ecommerce.shared.domain.event.EventBus
import joseahernandez.ecommerce.shared.domain.event.ItemCreatedDomainEventMother
import joseahernandez.ecommerce.shared.domain.event.warehouse.ItemCreatedDomainEvent
import joseahernandez.ecommerce.warehouse.domain.item.Item
import joseahernandez.ecommerce.warehouse.domain.item.ItemDuplicationException
import joseahernandez.ecommerce.warehouse.domain.item.mother.DescriptionMother
import joseahernandez.ecommerce.warehouse.domain.item.mother.ItemIdMother
import joseahernandez.ecommerce.warehouse.domain.item.mother.ItemNameMother
import joseahernandez.ecommerce.warehouse.domain.item.mother.PriceMother
import joseahernandez.ecommerce.warehouse.domain.item.mother.SizeMother
import joseahernandez.ecommerce.warehouse.domain.item.mother.WeightMother
import joseahernandez.ecommerce.warehouse.domain.warehouse.InvalidWarehouseIdException
import joseahernandez.ecommerce.warehouse.domain.warehouse.WarehouseId
import joseahernandez.ecommerce.warehouse.domain.warehouse.WarehouseMother
import joseahernandez.ecommerce.warehouse.infrastructure.repository.MemoryItemRepository
import joseahernandez.ecommerce.warehouse.infrastructure.repository.MemoryWarehouseRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ItemCreatorTest {
    private val eventBus = mockk<EventBus>(relaxed = true)
    private val warehouseRepository = MemoryWarehouseRepository()
    private val itemRepository = MemoryItemRepository()
    private val warehouseFinder = WarehouseFinder(warehouseRepository)
    private val itemFinder = ItemFinder(itemRepository)

    private val creator = ItemCreator(warehouseFinder, itemFinder, itemRepository, eventBus)

    @BeforeEach
    fun beforeEach() {
        clearMocks(eventBus)
        itemRepository.clear()
        warehouseRepository.clear()
    }

    @Test
    fun `Should create an item`() {
        val warehouse = WarehouseMother.create()
        warehouseRepository.save(warehouse)

        val itemId = ItemIdMother.create()
        val name = ItemNameMother.create()
        val description = DescriptionMother.create()
        val price = PriceMother.create()
        val size = SizeMother.create()
        val weight = WeightMother.create()

        val item = Item(itemId, name, description, price, size, weight)

        creator.execute(warehouse.id, itemId, name, description, price, size, weight)

        shouldHaveSaveItem(item)
        shouldHavePublishEvent(ItemCreatedDomainEventMother.fromItem(item))
    }

    @Test
    fun `Should create an item without setting the size and weight`() {
        val warehouse = WarehouseMother.create()
        warehouseRepository.save(warehouse)

        val itemId = ItemIdMother.create()
        val name = ItemNameMother.create()
        val description = DescriptionMother.create()
        val price = PriceMother.create()
        val size = null
        val weight = null

        val item = Item(itemId, name, description, price, size, weight)

        creator.execute(warehouse.id, itemId, name, description, price, size, weight)

        shouldHaveSaveItem(item)
        shouldHavePublishEvent(ItemCreatedDomainEventMother.fromItem(item))
    }

    @Test
    fun `Should throw exception when create an existing item`() {
        val warehouse = WarehouseMother.create()
        warehouseRepository.save(warehouse)

        val itemId = ItemIdMother.create()
        val name = ItemNameMother.create()
        val description = DescriptionMother.create()
        val price = PriceMother.create()
        val size = SizeMother.create()
        val weight = WeightMother.create()

        val item = Item(itemId, name, description, price, size, weight)
        itemRepository.save(item)

        Assertions.assertThrows(ItemDuplicationException::class.java) {
            creator.execute(warehouse.id, itemId, name, description, price, size, weight)
        }
    }

    @Test
    fun `Should throw exception when warehouse id is invalid`() {
        val invalidWarehouseId = WarehouseId(UUID.randomUUID())

        val itemId = ItemIdMother.create()
        val name = ItemNameMother.create()
        val description = DescriptionMother.create()
        val price = PriceMother.create()
        val size = SizeMother.create()
        val weight = WeightMother.create()

        Assertions.assertThrows(InvalidWarehouseIdException::class.java) {
            creator.execute(invalidWarehouseId, itemId, name, description, price, size, weight)
        }
    }

    private fun shouldHaveSaveItem(item: Item) {
        val itemFound = itemRepository.findById(item.id)
        Assertions.assertEquals(item, itemFound.get())
    }

    private fun shouldHavePublishEvent(event: ItemCreatedDomainEvent) {
        verify(exactly = 1) { eventBus.publish(listOf(event)) }
    }
}
