package org.lorenzo.repositories

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.lorenzo.DatabaseFactory
import org.lorenzo.model.Person
import org.lorenzo.schema.Persons

fun personRepository(): PersonRepository = object: PersonRepository {
	override suspend fun findById(id: Int): Person? =
		DatabaseFactory.dbQuery {
			Persons
				.select { Persons.id eq id}
				.map { it.toDomain() }
				.singleOrNull()
		}

	override suspend fun insert(person: Person): Int = DatabaseFactory.dbQuery {
		Persons.insert {
			it[name] = person.name
			it[surname] = person.surname
		}[Persons.id].value
	}

	private fun ResultRow.toDomain(): Person =
		Person(
			name = get(Persons.name),
			surname = get(Persons.surname)
		)

}