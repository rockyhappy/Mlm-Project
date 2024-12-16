package com.devrachit.mlm.presentation.auth.signupScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrachit.mlm.data.local.DataStoreRepository
import com.devrachit.mlm.data.remote.ApiServices
import com.devrachit.mlm.data.remote.dto.RegisterResponseDto
import com.devrachit.mlm.domain.models.UserModel
import com.devrachit.mlm.domain.repository.ApiServicesRepository
import com.devrachit.mlm.domain.sharedModels.UserRepository
import com.devrachit.mlm.domain.usecases.PostRegisterUser
import com.devrachit.mlm.utility.composeUtility.isValidEmail
import com.devrachit.mlm.utility.composeUtility.isValidPassword
import com.devrachit.mlm.utility.composeUtility.toMultipart
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

data class SignupStates(
    val email: String? = "",
    val name: String? = "",
    val mobile: String? = "",
    val password: String? = "",
    val confirmPassword: String? = "",
    val isLoading: Boolean = false,
    val isEmailValid: Boolean? = true,
    val isNameValid: Boolean? = true,
    val isMobileValid: Boolean? = true,
    val isPasswordValid: Boolean? = true,
    val isConfirmPasswordValid: Boolean? = true,
    val errorNameMessage: String = "",
    val errorMobileMessage: String = "",
    val errorEmailMessage: String = "",
    val errorPasswordMessage: String = "",
    val errorConfirmPasswordMessage: String = "",
    val registrationState: Boolean = false
)

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
    private val postRegisterUser: PostRegisterUser,
    private val apiServicesRepository: ApiServicesRepository,
    private val apiKey: String,
    private val userRepository: UserRepository
) : ViewModel() {

    val _uiStates = MutableStateFlow(SignupStates())
    val uiStates: StateFlow<SignupStates> = _uiStates.asStateFlow()

    fun setEmail(email: String) {
        _uiStates.value = _uiStates.value.copy(
            email = email
        )
    }

    fun setName(name: String) {
        _uiStates.value = _uiStates.value.copy(
            name = name
        )
    }

    fun setMobile(mobile: String) {
        _uiStates.value = _uiStates.value.copy(
            mobile = mobile
        )
    }

    fun setPassword(password: String) {
        _uiStates.value = _uiStates.value.copy(
            password = password
        )
    }

    fun setConfirmPassword(confirmPassword: String) {
        _uiStates.value = _uiStates.value.copy(
            confirmPassword = confirmPassword
        )
    }
    fun setRegistrationState(registrationState: Boolean) {
        _uiStates.value = _uiStates.value.copy(
            registrationState = registrationState
        )
    }

    fun onSignupClick() {
        if (_uiStates.value.email?.isValidEmail()?.not() == false) {
            _uiStates.value = _uiStates.value.copy(
                isEmailValid = true
            )
        } else {
            _uiStates.value = _uiStates.value.copy(
                isEmailValid = false,
                errorEmailMessage = "Invalid Email"
            )
        }
        if (_uiStates.value.password?.isValidPassword()?.not() == false) {
            _uiStates.value = _uiStates.value.copy(
                isPasswordValid = true
            )
        } else {
            _uiStates.value = _uiStates.value.copy(
                isPasswordValid = false,
                errorPasswordMessage = "Not a valid password"
            )
        }
        if (_uiStates.value.confirmPassword?.isValidPassword()?.not() == false) {
            _uiStates.value = _uiStates.value.copy(
                isConfirmPasswordValid = true
            )
        } else {
            _uiStates.value = _uiStates.value.copy(
                isConfirmPasswordValid = false,
                errorConfirmPasswordMessage = "Not a valid password"
            )
        }
        if ((_uiStates.value.name?.length ?: 1) > 3) {
            _uiStates.value = _uiStates.value.copy(
                isNameValid = true,
                errorNameMessage = "Name should be atleast 3 characters"
            )
        } else {
            Log.d("tag", _uiStates.value.name.toString())
            _uiStates.value = _uiStates.value.copy(
                isNameValid = false
            )
        }
        if ((_uiStates.value.mobile?.length ?: 0) >= 10) {
            _uiStates.value = _uiStates.value.copy(
                isMobileValid = true,
                errorMobileMessage = "Mobile number should be atleast 10 characters"
            )
        } else {
            _uiStates.value = _uiStates.value.copy(
                isMobileValid = false
            )
        }
        if (_uiStates.value.isEmailValid == true && _uiStates.value.isPasswordValid == true && _uiStates.value.isNameValid == true && _uiStates.value.isMobileValid == true && _uiStates.value.isConfirmPasswordValid == true) {
            viewModelScope.launch(Dispatchers.IO) {
                _uiStates.value = _uiStates.value.copy(
                    isLoading = true
                )

                val call=apiServicesRepository.registerUser(
                    authorization=apiKey,
                    name = (_uiStates.value.name?: "").toMultipart("name"),
                    password = (_uiStates.value.password ?: "").toMultipart("password"),
                    mobile = (_uiStates.value.mobile ?: "").toMultipart("mobile"),
                    action = "register".toMultipart("action"),
                    email = (_uiStates.value.email ?: "").toMultipart("email")
                )
                call.enqueue(object : Callback<RegisterResponseDto> {
                    override fun onResponse(call: Call<RegisterResponseDto>, response: Response<RegisterResponseDto>) {
                        if (response.isSuccessful) {
                            userRepository.setValues(UserModel(
                                email = _uiStates.value.email,
                                name = _uiStates.value.name,
                                mobile = _uiStates.value.mobile,
                                password = _uiStates.value.password
                            ))
                            _uiStates.value = _uiStates.value.copy(
                                isLoading = false,
                                registrationState = true
                            )
                        } else {
                            Log.e("API_CALL", "Error: ${response.code()} - ${response.errorBody()}")
                        }
                    }

                    override fun onFailure(call: Call<RegisterResponseDto>, t: Throwable) {
                        Log.e("API_CALL", "Failure: ${t.message}")
                    }
                })
            }

        }

    }

}