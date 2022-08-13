package org.lorenzo.schema

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

internal object Greetings: IntIdTable(name = "greeting") {

	val greetingsCounter: Column<Int> = integer("greetings_counter").default(0)
}