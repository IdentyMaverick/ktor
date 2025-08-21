import Database.UserRepository
import com.example.models.LoginResponse
import com.example.models.UserCredentials
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.util.toMap

// Login kontrolünün yapıldığı fonksiyon.

fun Route.loginRoute() {
    post("/login") {
        try {
            val rawBody = call.receiveText()
            val loginRequest = kotlinx.serialization.json.Json.decodeFromString<UserCredentials>(rawBody)

            val user = UserRepository.findUserByUsername(loginRequest.username)
            if (user != null && UserRepository.verifyPassword(loginRequest.password, user.password)) {
                val token = generateToken(user.userName)
                call.respond(HttpStatusCode.OK, LoginResponse(true, token))
            } else {
                call.respond(HttpStatusCode.Unauthorized, LoginResponse(false, "Kullanıcı adı veya şifre hatalı"))
            }

        } catch (e: Exception) {
            println("Hata: ${e.message}")
            call.respond(HttpStatusCode.BadRequest, "Geçersiz istek")
        }
    }


}