package org.lorenzo.services

import org.lorenzo.model.Person
import org.lorenzo.repositories.PersonRepository

interface PersonService {

	suspend fun addPerson(person: Person): Int
}

fun personService(personRepository: PersonRepository): PersonService = object: PersonService {
	override suspend fun addPerson(person: Person): Int = personRepository.insert(person)

}