package org.lorenzo.mappers

import org.lorenzo.dto.PersonDto
import org.lorenzo.model.Person

internal fun PersonDto.toDomain(): Person =
	Person(
		name = name,
		surname = surname,
	)