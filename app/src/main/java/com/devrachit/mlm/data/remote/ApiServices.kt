package com.devrachit.mlm.data.remote

import com.devrachit.mlm.data.remote.dto.ForgotPasswordDto
import com.devrachit.mlm.data.remote.dto.LoginResponseDto
import com.devrachit.mlm.data.remote.dto.RegisterResponseDto
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiServices {

    @Multipart
    @POST("api/userapi2")
    fun registerUser(
        @Header("Authorization") authorization: String,
        @Part name: MultipartBody.Part,
        @Part password: MultipartBody.Part,
        @Part mobile: MultipartBody.Part,
        @Part action: MultipartBody.Part,
        @Part email: MultipartBody.Part
    ): Call<RegisterResponseDto>

    @Multipart
    @POST("api/userapi2")
    fun verifyOtpRegister(
        @Header("Authorization") authorization: String,
        @Part name: MultipartBody.Part,
        @Part password: MultipartBody.Part,
        @Part mobile: MultipartBody.Part,
        @Part action: MultipartBody.Part,
        @Part email: MultipartBody.Part,
        @Part otp: MultipartBody.Part
    ): Call<RegisterResponseDto>

    @Multipart
    @POST("api/userapi2")
    fun loginUser(
        @Header("Authorization") authorization: String,
        @Part password: MultipartBody.Part,
        @Part mobile: MultipartBody.Part,
        @Part action: MultipartBody.Part,
    ): Call<LoginResponseDto>

    @Multipart
    @POST("api/userapi2")
    fun forgotPassword(
        @Header("Authorization") authorization: String,
        @Part mobile: MultipartBody.Part,
        @Part action: MultipartBody.Part,
    ): Call<ForgotPasswordDto>

    @Multipart
    @POST("api/userapi2")
    fun setNewPassword(
        @Header("Authorization") authorization: String,
        @Part mobile: MultipartBody.Part,
        @Part password: MultipartBody.Part,
        @Part otp : MultipartBody.Part,
        @Part action: MultipartBody.Part,
    ): Call<ForgotPasswordDto>
}