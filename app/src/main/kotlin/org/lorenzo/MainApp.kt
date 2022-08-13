package org.lorenzo

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.lorenzo.controllers.greet
import org.lorenzo.controllers.person

fun main() {
	val dependencies = Dependencies()
	embeddedServer(Netty, port = 8080) {
		DatabaseFactory.init()

		greet(dependencies.greetingService)
		person(dependencies.personService)
	}.start(wait = true)
}