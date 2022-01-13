package com.koendebruijn.clients.notification


data class NotificationRequest(
    val toCustomerId: Long,
    val toCustomerEmail: String,
    val message: String,
)