package com.koendebruijn.fraud

import com.koendebruijn.clients.fraud.FraudCheckHistoryResponse
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("api/v1/fraud-check")
class FraudCheckHistoryController(private val fraudCheckHistoryService: FraudCheckHistoryService) {

    @GetMapping("{customerId}")
    fun isFraudster(@PathVariable customerId: Long): FraudCheckHistoryResponse {

        val isFraudster: Boolean = fraudCheckHistoryService.isFraudulentCustomer(customerId)

        return FraudCheckHistoryResponse(isFraudster)
    }
}