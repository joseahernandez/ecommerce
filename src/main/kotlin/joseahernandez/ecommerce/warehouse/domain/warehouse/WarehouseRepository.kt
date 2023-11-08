package joseahernandez.ecommerce.warehouse.domain.warehouse

import java.util.Optional

interface WarehouseRepository {
    fun findById(id: WarehouseId): Optional<Warehouse>
    fun save(warehouse: Warehouse)
}
