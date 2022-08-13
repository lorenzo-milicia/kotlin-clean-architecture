package org.lorenzo.schema

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

internal object Persons: IntIdTable(name = "person") {

	val name: Column<String> = varchar("name", 128)
	val surname: Column<String> = varchar("surname", 128)
}