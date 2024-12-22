package com.devrachit.mlm.domain.usecases

import com.devrachit.mlm.data.remote.dto.RegisterResponseDto
import com.devrachit.mlm.domain.repository.ApiServicesRepository
import com.devrachit.mlm.utility.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import javax.inject.Inject

class PostRegisterOtpVerify @Inject constructor(
    private val apiServicesRepository: ApiServicesRepository
) {
    operator fun invoke(
        apiKey: String,
        name: MultipartBody.Part,
        password: MultipartBody.Part,
        mobile: MultipartBody.Part,
        action: MultipartBody.Part,
        email: MultipartBody.Part,
        otp: MultipartBody.Part
    ): Flow<Resource<RegisterResponseDto>> = flow {
        try{
            apiServicesRepository.verifyOtpRegister(
                authorization = apiKey,
                name = name,
                password = password,
                mobile = mobile,
                action = action,
                email = email,
                otp = otp
            )
        }
        catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }

    }
}