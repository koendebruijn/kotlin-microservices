package com.koendebruijn.clients.notification

import com.fasterxml.jackson.annotation.JsonProperty


data class NotificationRequest(
    @JsonProperty("toCustomerId")
    val toCustomerId: Long,
    @JsonProperty("toCustomerEmail")
    val toCustomerEmail: String,
    @JsonProperty("message")
    val message: String,
)