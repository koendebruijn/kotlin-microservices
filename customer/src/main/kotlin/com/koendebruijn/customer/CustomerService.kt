package com.koendebruijn.customer

import com.koendebruijn.customer.dto.CustomerRegistrationRequest
import com.koendebruijn.customer.dto.FraudCheckHistoryResponse
import com.koendebruijn.customer.exception.EmailTakenException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CustomerService(private val customerRepository: CustomerRepository, private val restTemplate: RestTemplate) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun registerCustomer(customerRequest: CustomerRegistrationRequest): Customer {
        val customer = Customer(
            firstName = customerRequest.firstname,
            lastName = customerRequest.lastname,
            email = customerRequest.email
        )

        checkIfEmailIsTaken(customer.email)

        customerRepository.saveAndFlush(customer)


        val fraudCheckHistoryResponse = restTemplate.getForObject(
            "http://FRAUD/api/v1/fraud-check/{customerId}",
            FraudCheckHistoryResponse::class.java,
            customer.id
        )

        if (fraudCheckHistoryResponse?.isFraudster == true) {
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