package com.devrachit.mlm.presentation.auth.otpScreen

import androidx.lifecycle.ViewModel
import com.devrachit.mlm.data.local.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class OtpStates(
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
) : ViewModel() {
    private val _otpState = MutableStateFlow(OtpStates())
    val otpState: StateFlow<OtpStates> = _otpState

    fun setOtp(otp: String) {
        _otpState.value = _otpState.value.copy(otp = otp)
    }
    fun onOtpClick(otp:String) {
        if (otp.length== 6) {
            setOtpValid(true)
        } else {
            setOtpValid(false)
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