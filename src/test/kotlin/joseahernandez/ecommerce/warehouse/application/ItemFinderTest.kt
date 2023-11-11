package joseahernandez.ecommerce.warehouse.application

import joseahernandez.ecommerce.warehouse.domain.item.Item
import joseahernandez.ecommerce.warehouse.domain.item.mother.ItemMother
import joseahernandez.ecommerce.warehouse.infrastructure.repository.MemoryItemRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.Optional

class ItemFinderTest {

    private val repository = MemoryItemRepository()
    private val finder = ItemFinder(repository)

    @BeforeEach
    fun beforeEach() {
        repository.clear()
    }

    @Test
    fun `Should find an item that exists`() {
        val item = ItemMother.create()
        repository.save(item)

        val itemFound = finder.run(item.id)
        Assertions.assertEquals(item, itemFound.get())
    }

    @Test
    fun `Should return empty when item does not exists`() {
        val item = ItemMother.create()

        val itemFound = finder.run(item.id)
        Assertions.assertEquals(Optional.empty<Item>(), itemFound)
    }
}
