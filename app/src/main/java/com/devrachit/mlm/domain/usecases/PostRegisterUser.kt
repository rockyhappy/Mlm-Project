package com.devrachit.mlm.domain.usecases

import android.util.Log
import com.devrachit.mlm.data.remote.dto.RegisterResponseDto
import com.devrachit.mlm.domain.repository.ApiServicesRepository
import com.devrachit.mlm.utility.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import javax.inject.Inject

class PostRegisterUser @Inject constructor(
    private val apiServicesRepository: ApiServicesRepository
) {
    operator fun invoke(
        apiKey: String,
        name: MultipartBody.Part,
        password: MultipartBody.Part,
        mobile: MultipartBody.Part,
        action: MultipartBody.Part,
        email: MultipartBody.Part
    ): Flow<Resource<RegisterResponseDto>> = flow {
        try {
            emit(Resource.Loading())

            // Perform API call
            val response = apiServicesRepository.registerUser(
                authorization = apiKey,
                name = name,
                password = password,
                mobile = mobile,
                action = action,
                email = email
            )
            Log.e("PostRegisterUser", "Response: $response")

        } catch (e: Exception) {
            Log.e("PostRegisterUser", "Error: ${e.localizedMessage}")
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}
