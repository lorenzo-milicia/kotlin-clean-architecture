package org.lorenzo

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import org.lorenzo.schema.Greetings
import org.lorenzo.schema.Persons

object DatabaseFactory {

	lateinit var database: Database

	fun init() {
		database = Database.connect(
			url = "jdbc:sqlite:cleanarch.db",
			driver = "org.sqlite.JDBC",
		)
		transaction(database) {
			SchemaUtils.create(Persons, Greetings)
		}
	}

	suspend fun <T> dbQuery(block: suspend () -> T): T =
		newSuspendedTransaction(Dispatchers.IO, database) { block() }
}