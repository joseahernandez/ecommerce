package joseahernandez.ecommerce.shared

import net.datafaker.Faker

abstract class DataFaker {
    companion object {
        @JvmStatic
        protected val faker by lazy { Faker() }
    }
}
