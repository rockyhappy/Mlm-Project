package com.devrachit.mlm.data.remote.dto

data class RegisterResponseDto(
    val `data`: Data,
    val message: String,
    val status: String
)
data class Data(
    val email: String,
    val mobile: String,
    val name: String
)
