package ru.viklover.customers.api.v1.service

import kotlinx.coroutines.flow.Flow

import ru.viklover.customers.contracts.v1.models.CustomerDto
import ru.viklover.customers.contracts.v1.models.CreateCustomerDto

interface CustomersService {
    suspend fun createCustomer(dto: CreateCustomerDto): CustomerDto
    suspend fun findById(id: Long): CustomerDto
    fun findAllBy(limit: Int?, offset: Int?): Flow<CustomerDto>
}
