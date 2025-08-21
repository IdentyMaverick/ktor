//import Database.DatabaseFactory
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, host = "192.168.0.246" , port = 9090) {
        //DatabaseFactory.init()

        install(ContentNegotiation) { json() } // JSON veri formatı desteği ekler.
        install(CORS) {
            anyHost() // Her yerden gelen isteklere izin ver.
            allowHeader(HttpHeaders.ContentType) // Content-Type başlığına izin verir.
            allowMethod(HttpMethod.Post) // POST ve GET isteklerine izin verir.
            allowMethod(HttpMethod.Get) // POST ve GET isteklerine izin verir.
        }
        routing {
            loginRoute() // loginRoute() fonksiyonunu çağırarak /login endpoint’ini aktif eder.
        }
    }.start(wait = true)
}