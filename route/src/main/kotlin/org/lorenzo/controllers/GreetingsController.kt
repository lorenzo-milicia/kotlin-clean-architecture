package org.lorenzo.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.lorenzo.services.GreetingService

fun Application.greet(greetings: GreetingService): Routing = routing {
	route("/greet") {
		get {
			val personId = call.parameters.getRequired("id").toInt()
			call.respondText(greetings.greet(personId))
		}
	}
}

private fun Parameters.getRequired(name: String): String =
	this[name] ?: throw BadRequestException("Required parameter '$name' missing")