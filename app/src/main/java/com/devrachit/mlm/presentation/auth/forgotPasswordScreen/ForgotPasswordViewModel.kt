package com.devrachit.mlm.presentation.auth.forgotPasswordScreen

import androidx.lifecycle.ViewModel
import com.devrachit.mlm.presentation.auth.loginScreen.LoginStates
import com.devrachit.mlm.utility.composeUtility.isValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


data class ForgotPasswordStates(
    val email:String? = "",
    val isLoading:Boolean = false,
    val isEmailValid : Boolean? = true,
    val errorEmailMessage : String = "",
)

@HiltViewModel
class ForgotPasswordViewModel@Inject constructor(
):ViewModel() {
    private var _uiStates = MutableStateFlow(ForgotPasswordStates())
    val uiStates : StateFlow<ForgotPasswordStates> = _uiStates.asStateFlow()

    fun setEmail(email:String)
    {
        _uiStates.value=_uiStates.value.copy(
            email = email
        )
    }

    fun onForgotPasswordClick()
    {
        if(_uiStates.value.email?.isValidEmail()?.not() == false)
        {
            _uiStates.value=_uiStates.value.copy(
                isEmailValid = true
            )
        }
        else{
            _uiStates.value=_uiStates.value.copy(
                isEmailValid = false,
                errorEmailMessage = "Invalid Email"
            )
        }
    }

}