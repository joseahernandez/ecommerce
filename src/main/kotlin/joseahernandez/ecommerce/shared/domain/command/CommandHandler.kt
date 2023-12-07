package joseahernandez.ecommerce.shared.domain.command

fun interface CommandHandler<T : Command, R: Any> {
    fun handle(command: T) : R
}
