package com.koendebruijn.fraud

import org.hibernate.Hibernate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class FraudCheckHistory (
    @Id
    @SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
    val id: Long = -1,
    val customerId: Long,
    val isFraudster: Boolean,
    val createdAt: LocalDateTime,
)