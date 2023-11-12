package joseahernandez.ecommerce.warehouse.application

import jakarta.inject.Singleton
import joseahernandez.ecommerce.warehouse.domain.warehouse.Warehouse
import joseahernandez.ecommerce.warehouse.domain.warehouse.WarehouseId
import joseahernandez.ecommerce.warehouse.domain.warehouse.WarehouseRepository
import java.util.Optional

@Singleton
class WarehouseFinder(private val repository: WarehouseRepository) {
    fun run(warehouseId: WarehouseId): Optional<Warehouse> =
        repository.findById(warehouseId)
}
