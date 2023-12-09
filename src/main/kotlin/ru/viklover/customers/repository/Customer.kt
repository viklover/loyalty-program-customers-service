package ru.viklover.customers.repository

import java.time.LocalDateTime

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table
class Customer(
    @Id private var id: Long? = null,
    @Column("created_at") private var createdAt: LocalDateTime? = null,
    val firstName: String,
    val lastName: String,
    val birthDay: LocalDateTime? = null
) {
    fun id() = checkNotNull(id)
    fun createdAt() = checkNotNull(createdAt)
}
