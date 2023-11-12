package joseahernandez.ecommerce.warehouse.application

import joseahernandez.ecommerce.warehouse.domain.warehouse.Warehouse
import joseahernandez.ecommerce.warehouse.domain.warehouse.WarehouseMother
import joseahernandez.ecommerce.warehouse.infrastructure.repository.MemoryWarehouseRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.Optional

class WarehouseFinderTest {
    private val repository = MemoryWarehouseRepository()
    private val finder = WarehouseFinder(repository)

    @BeforeEach
    fun beforeEach() {
        repository.clear()
    }

    @Test
    fun `Should find a warehouse that exists`() {
        val warehouse = WarehouseMother.create()
        repository.save(warehouse)

        val warehouseFound = finder.run(warehouse.id)
        Assertions.assertEquals(warehouse, warehouseFound.get())
    }

    @Test
    fun `Should return empty when warehouse does not exists`() {
        val warehouse = WarehouseMother.create()

        val warehouseFound = finder.run(warehouse.id)
        Assertions.assertEquals(Optional.empty<Warehouse>(), warehouseFound)
    }
}
