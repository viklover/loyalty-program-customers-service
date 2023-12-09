package ru.viklover.customers.repository

import kotlinx.coroutines.flow.Flow

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomersRepository : CoroutineCrudRepository<Customer, Long> {

    @Query("select * from customer limit :limit offset :offset")
    fun findAllBy(limit: Int?, offset: Int?): Flow<Customer>
}
