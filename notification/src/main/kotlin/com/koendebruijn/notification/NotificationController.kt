package com.koendebruijn.notification

import com.koendebruijn.clients.notification.NotificationRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/notification")
class NotificationController(private val notificationService: NotificationService) {

    @PostMapping
    fun sendNotification(@RequestBody notificationRequest: NotificationRequest) {

            notificationService.send(notificationRequest)

    }

}