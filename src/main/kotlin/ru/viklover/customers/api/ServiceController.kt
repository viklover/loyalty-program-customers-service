package ru.viklover.customers.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

import ru.viklover.customers.contracts.ServiceApi

@RestController
class ServiceController : ServiceApi {

    override suspend fun healthCheck(): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.OK)
    }
}
