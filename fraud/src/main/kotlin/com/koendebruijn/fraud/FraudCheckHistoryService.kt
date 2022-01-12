package com.koendebruijn.fraud

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FraudCheckHistoryService(private val fraudCheckHistoryRepository: FraudCheckHistoryRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun isFraudulentCustomer(customerId: Long): Boolean {
        logger.info("Adding fraud history for customer $customerId")

        val fraudCheckHistory = FraudCheckHistory(
            customerId = customerId,
            createdAt = LocalDateTime.now(),
            isFraudster = false
        )

        fraudCheckHistoryRepository.save(fraudCheckHistory)

        return false
    }
}