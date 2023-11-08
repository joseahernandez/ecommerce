package joseahernandez.ecommerce.warehouse.domain.warehouse

class WarehouseName(name: String) {
    companion object {
        private const val MIN_LENGTH = 3
        private const val MAX_LENGTH = 50
    }

    val value: String = name.trim()

    init {
        val length = value.length
        if (length > MAX_LENGTH || length < MIN_LENGTH) {
            throw InvalidWarehouseNameException("Warehouse name should have a length between $MIN_LENGTH and $MAX_LENGTH")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WarehouseName

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
