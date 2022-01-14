package com.koendebruijn.notification.rabbitmq

import com.koendebruijn.clients.notification.NotificationRequest
import com.koendebruijn.notification.NotificationService
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class NotificationConsumer(private val notificationService: NotificationService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @RabbitListener(queues = ["\${rabbitmq.queues.notification}"])
    fun consumer(notificationRequest: NotificationRequest) {
        logger.info("Consuming $notificationRequest from queue")

        notificationService.send(notificationRequest)
    }
}