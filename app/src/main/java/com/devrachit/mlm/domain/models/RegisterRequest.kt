package com.devrachit.mlm.domain.models

data class RegisterRequest(
    val name: String? = "",
    val password: String? = "",
    val mobile: String? = "",
)
