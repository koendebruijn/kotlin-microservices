package com.koendebruijn.customer

import com.koendebruijn.clients.fraud.FraudClient
import com.koendebruijn.customer.dto.CustomerRegistrationRequest
import com.koendebruijn.customer.exception.EmailTakenException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val fraudClient: FraudClient
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun registerCustomer(customerRequest: CustomerRegistrationRequest): Customer {
        val customer = Customer(
            firstName = customerRequest.firstname,
            lastName = customerRequest.lastname,
            email = customerRequest.email
        )

        checkIfEmailIsTaken(customer.email)

        customerRepository.saveAndFlush(customer)

        val fraudCheckHistoryResponse = fraudClient.isFraudster(customer.id)

        if (fraudCheckHistoryResponse.isFraudster) {
            logger.info("customer {} is a fraudster", customer.id)
            throw IllegalArgumentException()
        }

        return customer
    }

    private fun checkIfEmailIsTaken(email: String) {
        if (customerRepository.existsByEmail(email)) {
            throw EmailTakenException(email)
        }
    }
}