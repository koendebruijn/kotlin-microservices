package com.koendebruijn.notification

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class NotificationService(private val notificationRepository: NotificationRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun send(notification: Notification) {
        notificationRepository.save(notification)

        logger.info("sent notification $notification")

    }
}