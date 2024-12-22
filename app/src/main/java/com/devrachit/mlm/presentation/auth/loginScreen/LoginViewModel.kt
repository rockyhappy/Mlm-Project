package com.devrachit.mlm.presentation.auth.loginScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrachit.mlm.data.local.DataStoreRepository
import com.devrachit.mlm.data.remote.ApiServices
import com.devrachit.mlm.data.remote.dto.LoginResponseDto
import com.devrachit.mlm.data.remote.dto.RegisterResponseDto
import com.devrachit.mlm.domain.repository.ApiServicesRepository
import com.devrachit.mlm.domain.sharedModels.UserRepository
import com.devrachit.mlm.utility.composeUtility.isValidEmail
import com.devrachit.mlm.utility.composeUtility.isValidMobile
import com.devrachit.mlm.utility.composeUtility.isValidPassword
import com.devrachit.mlm.utility.composeUtility.toMultipart
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


data class LoginStates(
    val email:String? = "",
    val password:String? = "",
    val isLoading:Boolean = false,
    val isEmailValid : Boolean? = true,
    val isPasswordValid : Boolean? = true,
    val errorEmailMessage : String = "",
    val errorPasswordMessage : String = "",
    val mobile : String? = "",
    val isMobileValid: Boolean? = true,
    val errorMobileMessage : String = "",
    val loginState : Boolean = false
)
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
    private val apiServicesRepository: ApiServicesRepository,
    private val apiKey: String,
    private val userRepository: UserRepository
):ViewModel() {


    private var _uiStates = MutableStateFlow(LoginStates())
    val uiStates : StateFlow<LoginStates> = _uiStates.asStateFlow()

    fun onLoginClick()
    {
        if(_uiStates.value.mobile?.isValidMobile()==true)
        {
            _uiStates.value=_uiStates.value.copy(
                isMobileValid = true
            )
        }
        else{
            _uiStates.value=_uiStates.value.copy(
                isMobileValid = false,
                errorEmailMessage = "Invalid Mobile"
            )
        }
        if(_uiStates.value.password?.isValidPassword()?.not() == false)
        {
            _uiStates.value=_uiStates.value.copy(
                isPasswordValid = true
            )
        }
        else{
            _uiStates.value=_uiStates.value.copy(
                isPasswordValid = false,
                errorPasswordMessage = "Not a valid password"
            )
        }

        if(_uiStates.value.isMobileValid == true && _uiStates.value.isPasswordValid == true)
        {
            viewModelScope.launch(Dispatchers.IO) {

                _uiStates.value = _uiStates.value.copy(
                    isLoading = true
                )
                val call = apiServicesRepository.loginUser(
                    authorization = apiKey,
                    mobile = (_uiStates.value.mobile?: "").toMultipart("mobile"),
                    password = (_uiStates.value.password ?: "").toMultipart("password"),
                    action = "login".toMultipart("action")
                )
                call.enqueue(object : Callback<LoginResponseDto> {
                    override fun onResponse(
                        call: Call<LoginResponseDto>,
                        response: Response<LoginResponseDto>
                    ) {
                        if (response.isSuccessful) {
                            _uiStates.value = _uiStates.value.copy(
                                isLoading = false,
                                loginState = true
                            )
                            Log.d("LoginViewModel", "Response: ${response.body()}")
                        } else {
                            _uiStates.value = _uiStates.value.copy(
                                isLoading = false,
                                loginState = false
                            )
                        }
                    }

                    override fun onFailure(call: Call<LoginResponseDto>, t: Throwable) {
                        _uiStates.value = _uiStates.value.copy(
                            isLoading = false,
                            loginState = false
                        )
                    }

                })
            }
        }


    }

    fun setEmail(email:String)
    {
        _uiStates.value=_uiStates.value.copy(
            email = email
        )
    }
    fun setPassword(password:String)
    {
        _uiStates.value=_uiStates.value.copy(
            password = password
        )
    }
    fun setMobile(mobile:String)
    {
        _uiStates.value=_uiStates.value.copy(
            mobile = mobile
        )
    }

}