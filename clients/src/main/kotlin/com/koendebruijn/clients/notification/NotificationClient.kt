package com.koendebruijn.clients.notification

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    value = "notification",
    path = "api/v1/notification"
)
interface NotificationClient {
    @PostMapping
    fun sendNotification(@RequestBody notificationRequest: NotificationRequest)
}