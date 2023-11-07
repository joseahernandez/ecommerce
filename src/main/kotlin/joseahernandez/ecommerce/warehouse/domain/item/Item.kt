package joseahernandez.ecommerce.warehouse.domain.item

class Item(
    val id: ItemId,
    val name: ItemName,
    val description: Description,
    val price: Price,
    val size: Size?,
    val weight: Weight?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
