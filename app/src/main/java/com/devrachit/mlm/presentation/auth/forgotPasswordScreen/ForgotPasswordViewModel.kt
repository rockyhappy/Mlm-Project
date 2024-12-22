package com.devrachit.mlm.presentation.auth.forgotPasswordScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrachit.mlm.data.remote.dto.ForgotPasswordDto
import com.devrachit.mlm.domain.models.UserModel
import com.devrachit.mlm.domain.repository.ApiServicesRepository
import com.devrachit.mlm.domain.sharedModels.UserRepository
import com.devrachit.mlm.presentation.auth.loginScreen.LoginStates
import com.devrachit.mlm.utility.composeUtility.isValidEmail
import com.devrachit.mlm.utility.composeUtility.isValidMobile
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
import javax.inject.Inject


data class ForgotPasswordStates(
    val isLoading:Boolean = false,
    val forgotPasswordState : Boolean = false,
    val mobile : String? = "",
    val isMobileValid: Boolean? = true,
    val errorMobileMessage : String = ""
)

@HiltViewModel
class ForgotPasswordViewModel@Inject constructor(
    private val apiServicesRepository: ApiServicesRepository,
    private val apiKey: String,
    private val userRepository: UserRepository
):ViewModel() {
    private var _uiStates = MutableStateFlow(ForgotPasswordStates())
    val uiStates : StateFlow<ForgotPasswordStates> = _uiStates.asStateFlow()

    fun onMobileChange(mobile:String)
    {
        _uiStates.value=_uiStates.value.copy(
            mobile = mobile
        )
    }
    fun setForgotPasswordState(forgotPasswordState: Boolean)
    {
        userRepository.setValues(
            UserModel(
                mobile = _uiStates.value.mobile
            )
        )
        _uiStates.value=_uiStates.value.copy(
            forgotPasswordState = forgotPasswordState
        )
    }

    fun onForgotPasswordClick()
    {
        if(_uiStates.value.mobile?.isValidMobile()?.not() == false)
        {
            _uiStates.value=_uiStates.value.copy(
                isMobileValid = true
            )
        }
        else{
            _uiStates.value=_uiStates.value.copy(
                isMobileValid = false,
                errorMobileMessage = "Invalid Mobile"
            )
        }
        if(_uiStates.value.isMobileValid == true)
        {
            viewModelScope.launch(Dispatchers.IO) {
                try{
                    _uiStates.value=_uiStates.value.copy(
                        isLoading = true
                    )
                    val call = apiServicesRepository.forgotPassword(
                        authorization = apiKey,
                        mobile = (_uiStates.value.mobile?:"").toMultipart("mobile"),
                        action = "forget-password".toMultipart("action"),
                    )
                    call.enqueue(object : Callback<ForgotPasswordDto> {
                        override fun onResponse(call: Call<ForgotPasswordDto>, response: Response<ForgotPasswordDto>) {
                            if(response.isSuccessful)
                            {
                                _uiStates.value=_uiStates.value.copy(
                                    isLoading = false,
                                    forgotPasswordState = true
                                )
                            }
                            else{
                                _uiStates.value=_uiStates.value.copy(
                                    isLoading = false
                                )
                            }
                        }

                        override fun onFailure(call: Call<ForgotPasswordDto>, t: Throwable) {
                            _uiStates.value=_uiStates.value.copy(
                                isLoading = false
                            )
                        }
                    })

                    _uiStates.value=_uiStates.value.copy(
                        isLoading = false,
                        forgotPasswordState = true
                    )
                }catch (e:Exception)
                {
                    _uiStates.value=_uiStates.value.copy(
                        isLoading = false
                    )
                }
            }
        }
    }

}