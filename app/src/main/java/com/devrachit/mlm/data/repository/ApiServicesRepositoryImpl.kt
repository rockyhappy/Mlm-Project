package com.devrachit.mlm.data.repository

import com.devrachit.mlm.data.remote.ApiServices
import com.devrachit.mlm.data.remote.dto.RegisterResponseDto
import com.devrachit.mlm.domain.repository.ApiServicesRepository
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class ApiServicesRepositoryImpl @Inject constructor(
    private val apiService: ApiServices
): ApiServicesRepository {
    override suspend fun registerUser(
        authorization: String,
        name: MultipartBody.Part,
        password: MultipartBody.Part,
        mobile: MultipartBody.Part,
        action: MultipartBody.Part,
        email: MultipartBody.Part
    ): Call<RegisterResponseDto> {
        return apiService.registerUser(
            authorization,
            name,
            password,
            mobile,
            action,
            email
        )
    }

    override suspend fun verifyOtpRegister(
        authorization: String,
        name: MultipartBody.Part,
        password: MultipartBody.Part,
        mobile: MultipartBody.Part,
        action: MultipartBody.Part,
        email: MultipartBody.Part,
        otp: MultipartBody.Part
    ): Call<RegisterResponseDto> {
        return apiService.verifyOtpRegister(
            authorization,
            name,
            password,
            mobile,
            action,
            email,
            otp
        )
    }
}