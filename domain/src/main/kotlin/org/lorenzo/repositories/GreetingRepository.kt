package org.lorenzo.repositories

interface GreetingRepository {
	suspend fun findGreetingCounterById(id: Int): Int
	suspend fun increaseCounter(id: Int)
}