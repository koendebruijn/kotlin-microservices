package com.koendebruijn.fraud

import com.koendebruijn.fraud.dto.FraudCheckHistoryResponse
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("api/v1/fraud-check")
class FraudCheckHistoryController(private val fraudCheckHistoryService: FraudCheckHistoryService) {

    @GetMapping("{customerId}")
    fun checkFraud(@PathVariable customerId: Long): ResponseEntity<FraudCheckHistoryResponse> {

        val isFraudster: Boolean = fraudCheckHistoryService.isFraudulentCustomer(customerId)

        return ResponseEntity.ok().body(FraudCheckHistoryResponse(isFraudster))
    }
}