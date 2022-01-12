package com.koendebruijn.customer

import javax.persistence.*


@Entity
class Customer(
    @Id
    @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
    val id: Long? = null,
    val firstName: String,
    val lastName: String,
    val email: String
)