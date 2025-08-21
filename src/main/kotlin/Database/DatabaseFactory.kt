package Database

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        val db = Database.connect(
            url = "jdbc:postgresql://192.168.0.246:5432/test",
            driver = "org.postgresql.Driver",
            user = "postgres", // Kullanıcı adın
            password = "1234" // Şifren
        )
        transaction(db) {
            SchemaUtils.create(Users)
        }
    }
}