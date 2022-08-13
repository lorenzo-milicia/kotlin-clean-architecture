package org.lorenzo

import org.lorenzo.repositories.GreetingRepository
import org.lorenzo.repositories.PersonRepository
import org.lorenzo.repositories.greetingRepository
import org.lorenzo.repositories.personRepository
import org.lorenzo.services.GreetingService
import org.lorenzo.services.PersonService
import org.lorenzo.services.greetingService
import org.lorenzo.services.personService

class Dependencies {
	private val personRepository: PersonRepository = personRepository()
	private val greetingRepository: GreetingRepository = greetingRepository()

	val greetingService: GreetingService = greetingService(personRepository, greetingRepository)
	val personService: PersonService = personService(personRepository)
}