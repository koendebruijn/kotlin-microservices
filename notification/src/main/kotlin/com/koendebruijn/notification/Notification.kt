package com.koendebruijn.notification

import org.hibernate.Hibernate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Notification (
    @Id
    @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
    val id: Long = 0,
    val toCustomerId: Long,
    val toCustomerEmail: String,
    val sender: String,
    val message: String,
    val sentAt: LocalDateTime
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Notification

        return id != 0L && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , toCustomerId = $toCustomerId , toCustomerEmail = $toCustomerEmail , sender = $sender , message = $message , sentAt = $sentAt )"
    }
}