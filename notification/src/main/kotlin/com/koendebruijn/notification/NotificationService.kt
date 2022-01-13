package com.koendebruijn.notification

import org.springframework.stereotype.Service

@Service
class NotificationService(private val notificationRepository: NotificationRepository) {

    fun send(notification: Notification) {
        notificationRepository.save(notification)
    }
}