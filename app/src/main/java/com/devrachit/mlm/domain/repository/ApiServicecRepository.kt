package com.devrachit.mlm.domain.repository

import com.devrachit.mlm.data.remote.dto.RegisterResponseDto
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response

interface ApiServicesRepository {
    suspend fun registerUser(
        authorization: String,
        name: MultipartBody.Part,
        password: MultipartBody.Part,
        mobile: MultipartBody.Part,
        action: MultipartBody.Part,
        email: MultipartBody.Part
    ): Call<RegisterResponseDto>

    suspend fun verifyOtpRegister(
        authorization: String,
        name: MultipartBody.Part,
        password: MultipartBody.Part,
        mobile: MultipartBody.Part,
        action: MultipartBody.Part,
        email: MultipartBody.Part,
        otp: MultipartBody.Part
    ): Call<RegisterResponseDto>
}