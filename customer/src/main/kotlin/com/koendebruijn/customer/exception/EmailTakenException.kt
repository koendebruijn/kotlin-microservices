package com.koendebruijn.customer.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.server.ResponseStatusException

class EmailTakenException(email: String) : ResponseStatusException(HttpStatus.BAD_REQUEST, "$email is already taken")