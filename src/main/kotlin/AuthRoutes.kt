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
            println("Raw body: $rawBody")
            val loginRequest = kotlinx.serialization.json.Json.decodeFromString<UserCredentials>(rawBody)
            println("LoginRequest is: ${loginRequest.username}")
            val token = generateToken(username = loginRequest.username)
            if (loginRequest.username=="admin" && loginRequest.password=="1234") {
                call.respond(HttpStatusCode.OK, LoginResponse(true, token))
            } else {
                call.respond(HttpStatusCode.OK, LoginResponse(false,"Kullanıcı adı veya şifre hatalı"))
            }

        } catch (e: Exception) {
            println("Hata: ${e.message}")
            call.respond(HttpStatusCode.BadRequest, "Wrong")
        }
    }


}