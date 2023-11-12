package joseahernandez.ecommerce.warehouse.domain.warehouse

import joseahernandez.ecommerce.shared.DataFaker
import java.util.UUID

class WarehouseMother : DataFaker() {
    companion object {
        fun create(
            id: WarehouseId = WarehouseId(UUID.randomUUID()),
            name: WarehouseName = WarehouseName(faker.company().name()),
            address: Address = Address(
                street = faker.address().streetName(),
                city = faker.address().city(),
                country = faker.address().country(),
            ),
        ) = Warehouse(id, name, address)
    }
}
