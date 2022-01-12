package com.koendebruijn.fraud

import org.springframework.data.jpa.repository.JpaRepository

interface FraudCheckHistoryRepository : JpaRepository<FraudCheckHistory, Long>