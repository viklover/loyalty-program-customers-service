package ru.viklover.customers.api.v1.util

import ru.viklover.customers.repository.Customer
import ru.viklover.customers.contracts.v1.models.CustomerDto

fun Customer.toDto(): CustomerDto {
    return CustomerDto(
        firstName = firstName,
        lastName = lastName,
        birthDay = birthDay?.toString(),
        createdAt = createdAt().toString()
    )
}
