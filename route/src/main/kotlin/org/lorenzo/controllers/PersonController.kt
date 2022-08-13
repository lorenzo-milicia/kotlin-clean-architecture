package org.lorenzo.controllers

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.lorenzo.dto.PersonDto
import org.lorenzo.mappers.toDomain
import org.lorenzo.services.PersonService

fun Application.person(persons: PersonService): Routing = routing {
	install(ContentNegotiation) {
		json()
	}
	route("/persons") {
		post {
			val person = call.receive<PersonDto>()

			val id = persons.addPerson(person.toDomain())

			call.respond(HttpStatusCode.OK, id)
		}
	}
}