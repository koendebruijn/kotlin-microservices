package com.koendebruijn.customer.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class CustomerRegistrationRequest(
    @field:NotBlank
    val firstname: String,

    @field:NotBlank
    val lastname: String,

    @field:Email
    @field:NotBlank
    val email: String
);