package com.koendebruijn.amqp

import org.slf4j.LoggerFactory
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.stereotype.Component

@Component
class RabbitMQMessageProducer(private val amqpTemplate: AmqpTemplate) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun publish(payload: Any, exchange: String, routingKey: String) {
        logger.info("Publishing to $exchange using routingKey $routingKey. payload: $payload")
        amqpTemplate.convertAndSend(exchange, routingKey, payload)
        logger.info("Published to $exchange using routingKey $routingKey. payload: $payload")

    }
}