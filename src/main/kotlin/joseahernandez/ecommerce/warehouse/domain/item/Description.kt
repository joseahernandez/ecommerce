package joseahernandez.ecommerce.warehouse.domain.item

class Description(description: String) {
    companion object {
        private const val MAX_LENGTH = 5_000
    }

    val value = description.trim()

    init {
        val length = value.length
        if (length > MAX_LENGTH) {
            throw InvalidItemDescriptionException("Item description shouldn't have more than $MAX_LENGTH characters")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Description

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
