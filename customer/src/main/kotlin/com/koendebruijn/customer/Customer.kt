package com.koendebruijn.customer

import org.hibernate.Hibernate
import javax.persistence.*


@Entity
data class Customer(
    @Id
    @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    val email: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Customer

        return id != 0L && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()
    
    override fun toString(): String {
        return "Customer(id=$id, firstName='$firstName', lastName='$lastName', email='$email')"
    }

}