package ru.viklover.customers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomersServiceApplication

fun main(args: Array<String>) {
    runApplication<CustomersServiceApplication>(*args)
}
