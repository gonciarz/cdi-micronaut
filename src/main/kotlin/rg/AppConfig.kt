package rg

import arrow.core.Either
import io.micronaut.context.annotation.Factory
import jakarta.inject.Named
import jakarta.inject.Singleton

typealias AssignKeyboard = suspend (String) -> Either<KeyboardError, Unit>
typealias AssignMouse = suspend (String) -> Either<MouseError, Unit>

sealed interface KeyboardError {
    object ExecutionError : KeyboardError
}

sealed interface MouseError {
    object ExecutionError : MouseError
}

@Factory
class AppConfig {

    @Singleton
    @Named(BeanName.ASSIGN_KEYBOARD)
    fun assignLocalKeyboardBean(shellAdapter: ShellAdapter): AssignKeyboard =
        shellAdapter::assignKeyboard

    @Singleton
    @Named(BeanName.ASSIGN_MOUSE)
    fun assignLocalMouseBean(shellAdapter: ShellAdapter): AssignMouse =
        shellAdapter::assignMouse
}

object BeanName {
    const val ASSIGN_KEYBOARD = "AssignKeyboard"
    const val ASSIGN_MOUSE = "AssignMouse"
}