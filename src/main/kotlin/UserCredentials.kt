package com.example.models

import kotlinx.serialization.Serializable


@Serializable
data class UserCredentials(val username: String, val password: String)

@Serializable
data class LoginResponse(val success: Boolean, val message: String)
