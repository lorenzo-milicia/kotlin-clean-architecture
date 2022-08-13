package org.lorenzo.services

import org.lorenzo.repositories.GreetingRepository
import org.lorenzo.repositories.PersonRepository

interface GreetingService {

	suspend fun greet(personId: Int): String
}

fun greetingService(persons: PersonRepository, greetings: GreetingRepository): GreetingService =
	object: GreetingService {
		override suspend fun greet(personId: Int): String {
			val person = persons.findById(personId) ?: return "I don't know you"

			val previousGreetingsCounter = greetings.findGreetingCounterById(personId)

			val greeting = if (previousGreetingsCounter < 5) "Hello, good Sir ${person.surname}"
			else if (previousGreetingsCounter == 5) "We know each other pretty well now, ${person.name}"
			else "Hi Fam, how are you doing this fine day?"

			greetings.increaseCounter(personId)
			return greeting
		}
	}