package joseahernandez.ecommerce.warehouse.domain.item.mother

import joseahernandez.ecommerce.warehouse.domain.item.ItemId
import java.util.UUID

class ItemIdMother {
    companion object {
        fun create(id: UUID = UUID.randomUUID()) = ItemId(id)
    }
}
