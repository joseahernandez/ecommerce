package joseahernandez.ecommerce.warehouse.domain.warehouse

class Warehouse(
    val id: WarehouseId,
    val name: WarehouseName,
    val address: Address,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Warehouse

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
