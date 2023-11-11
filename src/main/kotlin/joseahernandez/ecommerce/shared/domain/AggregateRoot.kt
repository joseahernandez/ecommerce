package joseahernandez.ecommerce.shared.domain

import joseahernandez.ecommerce.shared.domain.event.DomainEvent

abstract class AggregateRoot {
    private var events = mutableListOf<DomainEvent>()

    protected fun record(event: DomainEvent) {
        events.add(event)
    }

    fun pullDomainEvents(): List<DomainEvent> {
        val currentEvents = this.events
        this.events = mutableListOf()

        return currentEvents
    }
}
