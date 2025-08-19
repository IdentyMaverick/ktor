package Database

import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val id = integer("id").autoIncrement()
    val userName = varchar("username", 50).uniqueIndex()
    val password = varchar("password", 64) // Hash olarak tutulacak.
    override val primaryKey = PrimaryKey(id)
}