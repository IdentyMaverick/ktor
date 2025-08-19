/*package Database

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        val db = Database.connect(
            url = "",
            driver = "org.postgresql.Driver",
            user = "postgres", // Kullanıcı adın
            password = "" // Şifren
        )
        transaction(db) {
            SchemaUtils.create(Users)
        }
    }
}*/