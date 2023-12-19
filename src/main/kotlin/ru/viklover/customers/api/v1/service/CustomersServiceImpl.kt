package ru.viklover.customers.api.v1.service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

import org.springframework.stereotype.Service

import ru.viklover.customers.exception.ItemNotFoundException

import ru.viklover.customers.api.v1.util.toDto
import ru.viklover.customers.repository.Customer
import ru.viklover.customers.repository.CustomersRepository
import ru.viklover.customers.contracts.v1.models.CustomerDto
import ru.viklover.customers.contracts.v1.models.CreateCustomerDto
import java.time.LocalDateTime

@Service
class CustomersServiceImpl(
    private val customersRepository: CustomersRepository
) : CustomersService {

    override suspend fun createCustomer(dto: CreateCustomerDto): CustomerDto {
        val customerId = customersRepository.save(
            Customer(
                firstName = dto.firstName,
                lastName = dto.lastName,
                birthDay = if (dto.birthDay != null) LocalDateTime.parse(dto.birthDay) else null
            )
        ).id()

        return findById(customerId)
    }

    override suspend fun findById(id: Long): CustomerDto =
        customersRepository.findById(id)?.toDto() ?: throw ItemNotFoundException.of(Customer::class, id)

    override fun findAllBy(limit: Int?, offset: Int?): Flow<CustomerDto> =
        customersRepository.findAllBy(limit, offset).map { it.toDto() }
}