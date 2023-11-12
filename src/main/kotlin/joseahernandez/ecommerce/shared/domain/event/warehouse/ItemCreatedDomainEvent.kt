package joseahernandez.ecommerce.shared.domain.event.warehouse

import joseahernandez.ecommerce.shared.domain.event.DomainEvent
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class ItemCreatedDomainEvent(
    val id: UUID,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val length: Float?,
    val width: Float?,
    val height: Float?,
    val weight: Float?,
) : DomainEvent {
    private val occurredOn = LocalDateTime.now()

    override fun occurredOn(): LocalDateTime = occurredOn
}
