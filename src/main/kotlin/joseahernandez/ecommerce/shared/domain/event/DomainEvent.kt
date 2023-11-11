package joseahernandez.ecommerce.shared.domain.event

import java.time.LocalDateTime

interface DomainEvent {
    fun occurredOn(): LocalDateTime
}
