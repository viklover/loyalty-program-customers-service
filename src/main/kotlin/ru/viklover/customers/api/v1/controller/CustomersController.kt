package ru.viklover.customers.api.v1.controller

import kotlinx.coroutines.flow.Flow

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import ru.viklover.customers.api.v1.service.CustomersService

import ru.viklover.customers.contracts.v1.controller.CustomersControllerV1
import ru.viklover.customers.contracts.v1.models.CreateCustomerDto
import ru.viklover.customers.contracts.v1.models.CustomerDto

@RestController
class CustomersController(
    private val customersService: CustomersService
) : CustomersControllerV1
{
    override suspend fun createCustomer(createCustomerDto: CreateCustomerDto): ResponseEntity<CustomerDto> {
        return ResponseEntity.ok(customersService.createCustomer(createCustomerDto))
    }

    override fun findAll(limit: Int?, offset: Int?): ResponseEntity<Flow<CustomerDto>> {
        return ResponseEntity.ok(customersService.findAllBy(limit, offset))
    }
}
