package rg

import arrow.core.Either
import arrow.core.right
import jakarta.inject.Singleton
import kotlinx.coroutines.delay

@Singleton
class ShellAdapter {

    suspend fun assignKeyboard(computer: String): Either<KeyboardError, Unit> {
        delay(100)
        return Unit.right()
    }

    suspend fun assignMouse(computer: String): Either<MouseError, Unit> {
        delay(100)
        return Unit.right()
    }

}