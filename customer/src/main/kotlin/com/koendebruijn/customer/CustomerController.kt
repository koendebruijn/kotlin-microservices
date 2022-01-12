package com.koendebruijn.customer

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.koendebruijn.customer.dto.CustomerRegistrationRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/customer")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping
    fun registerCustomer(@RequestBody @Valid customerRequest: CustomerRegistrationRequest): ResponseEntity<Customer> {
        val customer: Customer = customerService.registerCustomer(customerRequest)
        return ResponseEntity.ok().body(customer)
    }

}