package com.koendebruijn.clients.fraud

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    value = "fraud",
    path = "api/v1/fraud-check"
)
interface FraudClient {
    @GetMapping("{customerId}")
    fun isFraudster(@PathVariable customerId: Long): FraudCheckHistoryResponse
}