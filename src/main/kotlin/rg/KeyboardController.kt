package rg

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject
import jakarta.inject.Named

@Controller("/api")
class KeyboardController(
    @Named(BeanName.ASSIGN_KEYBOARD)
    @Inject private val assignKeyboard: AssignKeyboard,
) {

    @Post(value = "/keyboard")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    suspend fun index(@Body switchActiveComputer: SwitchKeyboardDto): HttpResponse<Unit> =
        assignKeyboard(switchActiveComputer.computer).fold(
            { HttpResponse.badRequest() },
            { HttpResponse.accepted() }
        )
}

data class SwitchKeyboardDto(
    val computer: String,
)
