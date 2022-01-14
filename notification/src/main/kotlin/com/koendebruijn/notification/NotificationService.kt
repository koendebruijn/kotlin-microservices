package com.koendebruijn.notification

import com.koendebruijn.clients.notification.NotificationRequest
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class NotificationService(private val notificationRepository: NotificationRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun send(notificationRequest: NotificationRequest) {

        val notification = Notification(
            message = notificationRequest.message,
            toCustomerId = notificationRequest.toCustomerId,
            toCustomerEmail = notificationRequest.toCustomerEmail,
            sender = "Koen de Bruijn",
            sentAt = LocalDateTime.now()
        )

        notificationRepository.save(notification)

        logger.info("sent notification $notification")

    }
}