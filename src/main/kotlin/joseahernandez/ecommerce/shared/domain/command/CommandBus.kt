package joseahernandez.ecommerce.shared.domain.command

interface CommandBus {
    fun <T : Command, R: Any> handle(command: T) : R
}
