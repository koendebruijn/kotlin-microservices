package com.koendebruijn.customer

import org.springframework.data.jpa.repository.JpaRepository
import com.koendebruijn.customer.Customer
import org.springframework.stereotype.Repository

interface CustomerRepository : JpaRepository<Customer, Long> {
    fun existsByEmail(email: String): Boolean
}