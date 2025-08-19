package Database

import org.jetbrains.exposed.sql.Op
import org.jetbrains.exposed.sql.SqlExpressionBuilder
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
//import org.mindrot.jbcrypt.BCrypt

object UserRepository { // Kullanıcı doğrulama fonksiyonu
    fun findUserByUsername(username: String): User? {
        return transaction {
            Users.selectAll().where { Users.userName eq username }
                .map { User(it[Users.id], it[Users.userName], it[Users.password]) }
                .singleOrNull()
        }
    }
    fun verifyPassword (plainPassword: String, hashedPassword: String): Boolean {
        return true //BCrypt.checkpw(plainPassword, hashedPassword)
    }
}