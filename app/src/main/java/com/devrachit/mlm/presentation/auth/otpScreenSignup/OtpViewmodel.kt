package com.devrachit.mlm.presentation.auth.otpScreenSignup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrachit.mlm.data.local.DataStoreRepository
import com.devrachit.mlm.data.remote.dto.RegisterResponseDto
import com.devrachit.mlm.domain.repository.ApiServicesRepository
import com.devrachit.mlm.domain.sharedModels.UserRepository
import com.devrachit.mlm.utility.composeUtility.toMultipart
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


data class OtpStatesRegister(
    val otp: String = "",
    val isOtpValid: Boolean? = true,
    val isOtpSent: Boolean = false,
    val isOtpVerified: Boolean = false,
    val isOtpResend: Boolean = false,
    val isOtpError: Boolean = false,
    val isOtpLoading: Boolean = false,
    val isOtpResendLoading: Boolean = false,
    val errorOtpMessage: String = ""

)

@HiltViewModel
class OtpViewmodel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
    private val userRepository: UserRepository,
    private val apiServicesRepository: ApiServicesRepository,
    private val apiKey: String,
) : ViewModel() {

    init {
        Log.d("OtpViewmodel", "OtpViewmodel: ${userRepository.getValues()}")
    }

    private val _otpState = MutableStateFlow(OtpStatesRegister())
    val otpState: StateFlow<OtpStatesRegister> = _otpState

    fun setOtp(otp: String) {
        _otpState.value = _otpState.value.copy(otp = otp)
    }

    fun onOtpClick(otp: String) {
        if (otp.length == 6) {
            setOtpValid(true)
        } else {
            setOtpValid(false)
        }
        if (_otpState.value.isOtpValid == true) {
            viewModelScope.launch(Dispatchers.IO) {
                _otpState.value = _otpState.value.copy(
                    isOtpLoading = true
                )

                val call = apiServicesRepository.verifyOtpRegister(
                    authorization = apiKey,
                    otp = _otpState.value.otp.toMultipart("otp"),
                    name = (userRepository.getValues().name ?: "").toMultipart("name"),
                    password = (userRepository.getValues().password ?: "").toMultipart("password"),
                    mobile = (userRepository.getValues().mobile ?: "").toMultipart("mobile"),
                    action = "reg-otp".toMultipart("action"),
                    email = (userRepository.getValues().email ?: "").toMultipart("email")

                )
                println("API CALL: $call")
                call.enqueue(object : Callback<RegisterResponseDto> {
                    override fun onResponse(
                        call: Call<RegisterResponseDto>,
                        response: Response<RegisterResponseDto>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("API_CALL", "Response: ${response.body()}")
                            _otpState.value = _otpState.value.copy(
                                isOtpLoading = false,
                                isOtpVerified = true
                            )
                        } else {
                            Log.e("API_CALL", "Error: ${response.code()} - ${response.errorBody()}")
                            _otpState.value = _otpState.value.copy(
                                isOtpLoading = false,
                                isOtpError = true,
                                isOtpValid = false,
                                errorOtpMessage = if(response.code()==400)"Invalid Otp " else "An unexpected error occurred"
                            )
                        }
                    }

                    override fun onFailure(call: Call<RegisterResponseDto>, t: Throwable) {
                        Log.e("API_CALL", "Failure: ${t.message}")
                        _otpState.value = _otpState.value.copy(
                            isOtpLoading = false,
                            isOtpError = true,
                            errorOtpMessage = t.message ?: "An unexpected error occurred"
                        )
                    }
                })
            }
        }
    }

    fun setOtpValid(isOtpValid: Boolean) {
        _otpState.value = _otpState.value.copy(isOtpValid = isOtpValid)
    }

    fun setOtpSent(isOtpSent: Boolean) {
        _otpState.value = _otpState.value.copy(isOtpSent = isOtpSent)
    }

    fun setOtpVerified(isOtpVerified: Boolean) {
        _otpState.value = _otpState.value.copy(isOtpVerified = isOtpVerified)
    }

    fun setOtpResend(isOtpResend: Boolean) {
        _otpState.value = _otpState.value.copy(isOtpResend = isOtpResend)
    }

    fun setOtpError(isOtpError: Boolean) {
        _otpState.value = _otpState.value.copy(isOtpError = isOtpError)
    }

    fun setOtpLoading(isOtpLoading: Boolean) {
        _otpState.value = _otpState.value.copy(isOtpLoading = isOtpLoading)
    }

    fun setOtpResendLoading(isOtpResendLoading: Boolean) {
        _otpState.value = _otpState.value.copy(isOtpResendLoading = isOtpResendLoading)
    }
}