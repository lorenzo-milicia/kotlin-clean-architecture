package org.lorenzo.repositories

import org.lorenzo.model.Person

interface PersonRepository {
	suspend fun findById(id: Int): Person?
	suspend fun insert(person: Person): Int
}