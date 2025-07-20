import com.example.models.UserCredentials
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.http.*

// Login kontrolünün yapıldığı fonksiyon.

fun Route.loginRoute() {
post("/login"){
    val credentials = call.receive<UserCredentials>()
    if (credentials.username == "admin" && credentials.password == "1234") {
        call.respond(HttpStatusCode.OK, "Login Successful")
    } else {
        call.respond(HttpStatusCode.Unauthorized, "Invalid username or password")
    }
}
}