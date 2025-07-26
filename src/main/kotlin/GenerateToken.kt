import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.util.*

fun generateToken(username: String): String {
    val secret = "SUPER_SECRET_KEY" // Güvenli bir yerde sakla
    val algorithm = Algorithm.HMAC256(secret)
    return JWT.create()
        .withIssuer("ktor-backend")
        .withClaim("username", username)
        .withExpiresAt(Date(System.currentTimeMillis() + 3600_000)) // 1 saat geçerli
        .sign(algorithm)
}