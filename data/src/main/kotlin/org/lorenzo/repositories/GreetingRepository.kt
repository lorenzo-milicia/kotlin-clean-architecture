package org.lorenzo.repositories

import org.jetbrains.exposed.sql.SqlExpressionBuilder
import org.jetbrains.exposed.sql.insertIgnore
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update
import org.lorenzo.DatabaseFactory
import org.lorenzo.schema.Greetings

fun greetingRepository(): GreetingRepository = object: GreetingRepository {
	override suspend fun findGreetingCounterById(id: Int): Int =
		DatabaseFactory.dbQuery {
			Greetings
				.select { Greetings.id eq id }
				.map { it[Greetings.greetingsCounter] }
				.singleOrNull() ?: 0

		}

	override suspend fun increaseCounter(id: Int) {
		DatabaseFactory.dbQuery {
			Greetings.insertIgnore {
				it[greetingsCounter] = 0
			}
			Greetings.update({ Greetings.id eq id }) {
				with(SqlExpressionBuilder) {
					it.update(greetingsCounter, greetingsCounter + 1)
				}
			}
		}
	}
}