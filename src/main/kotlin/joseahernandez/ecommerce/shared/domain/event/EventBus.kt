package joseahernandez.ecommerce.shared.domain.event

interface EventBus {
    fun publish(events: List<DomainEvent>)
}
