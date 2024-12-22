package com.devrachit.mlm.data.remote.dto

data class LoginResponseDto(
    val action : String?="",
    val message : String?="",
    val token: String?="",
)