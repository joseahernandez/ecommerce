package joseahernandez.ecommerce.warehouse.infrastructure.repository

import jakarta.inject.Singleton
import joseahernandez.ecommerce.warehouse.domain.warehouse.Warehouse
import joseahernandez.ecommerce.warehouse.domain.warehouse.WarehouseId
import joseahernandez.ecommerce.warehouse.domain.warehouse.WarehouseRepository
import java.util.Optional

@Singleton
class MemoryWarehouseRepository : WarehouseRepository {
    private val warehouses: MutableMap<WarehouseId, Warehouse> = mutableMapOf()

    override fun findById(id: WarehouseId): Optional<Warehouse> {
        return if (warehouses.containsKey(id)) {
            Optional.of(warehouses.getValue(id))
        } else {
            Optional.empty()
        }
    }

    override fun save(warehouse: Warehouse) {
        warehouses[warehouse.id] = warehouse
    }

    fun clear() = warehouses.clear()
}
