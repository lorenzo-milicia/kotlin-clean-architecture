package org.lorenzo.dto

import kotlinx.serialization.Serializable

@Serializable
internal data class PersonDto(
	val name: String,
	val surname: String,
)
