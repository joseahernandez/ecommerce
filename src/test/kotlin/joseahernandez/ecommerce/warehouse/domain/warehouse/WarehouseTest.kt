package joseahernandez.ecommerce.warehouse.domain.warehouse

import joseahernandez.ecommerce.shared.domain.event.ItemCreatedDomainEventMother
import joseahernandez.ecommerce.warehouse.domain.item.Item
import joseahernandez.ecommerce.warehouse.domain.item.mother.DescriptionMother
import joseahernandez.ecommerce.warehouse.domain.item.mother.ItemIdMother
import joseahernandez.ecommerce.warehouse.domain.item.mother.ItemNameMother
import joseahernandez.ecommerce.warehouse.domain.item.mother.PriceMother
import joseahernandez.ecommerce.warehouse.domain.item.mother.SizeMother
import joseahernandez.ecommerce.warehouse.domain.item.mother.WeightMother
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WarehouseTest {
    @Test
    fun `Should create an item`() {
        val warehouse = WarehouseMother.create()

        val itemId = ItemIdMother.create()
        val name = ItemNameMother.create()
        val description = DescriptionMother.create()
        val price = PriceMother.create()
        val size = SizeMother.create()
        val weight = WeightMother.create()

        val itemExpected = Item(itemId, name, description, price, size, weight)
        val eventExpected = ItemCreatedDomainEventMother.fromItem(itemExpected)

        val item = warehouse.createItem(itemId, name, description, price, size, weight)

        Assertions.assertEquals(itemExpected, item)
        Assertions.assertEquals(eventExpected, warehouse.pullDomainEvents()[0])
    }
}
