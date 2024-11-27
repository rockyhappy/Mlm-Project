package com.devrachit.mlm.presentation.auth.signupScreen

import androidx.lifecycle.ViewModel
import com.devrachit.mlm.data.local.DataStoreRepository
import com.devrachit.mlm.utility.composeUtility.isValidEmail
import com.devrachit.mlm.utility.composeUtility.isValidPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class SignupStates(
    val email:String? = "",
    val password:String? = "",
    val confirmPassword:String? = "",
    val isLoading:Boolean = false,
    val isEmailValid : Boolean? = true,
    val isPasswordValid : Boolean? = true,
    val isConfirmPasswordValid : Boolean? = true,
    val errorEmailMessage : String = "",
    val errorPasswordMessage : String = "",
    val errorConfirmPasswordMessage : String = ""
)

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
):ViewModel() {

    val _uiStates= MutableStateFlow(SignupStates())
    val uiStates: StateFlow<SignupStates> = _uiStates.asStateFlow()

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
    fun setConfirmPassword(confirmPassword:String)
    {
        _uiStates.value=_uiStates.value.copy(
            confirmPassword = confirmPassword
        )
    }
    fun onSignupClick()
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
        if(_uiStates.value.confirmPassword?.isValidPassword()?.not() == false)
        {
            _uiStates.value=_uiStates.value.copy(
                isConfirmPasswordValid = true
            )
        }
        else{
            _uiStates.value=_uiStates.value.copy(
                isConfirmPasswordValid = false,
                errorConfirmPasswordMessage = "Not a valid password"
            )
        }
    }

}