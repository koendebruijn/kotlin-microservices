package com.koendebruijn.customer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication(
    scanBasePackages = ["com.koendebruijn.amqp", "com.koendebruijn.customer"]
)
@EnableEurekaClient
@EnableFeignClients(basePackages = ["com.koendebruijn.clients"])
class CustomerApplication

fun main(args: Array<String>) {
    runApplication<CustomerApplication>(*args)
}