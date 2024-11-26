package com.devrachit.mlm.presentation.auth.loginScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.devrachit.mlm.data.local.DataStoreRepository
import com.devrachit.mlm.utility.composeUtility.isValidEmail
import com.devrachit.mlm.utility.composeUtility.isValidPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


data class LoginStates(
    val email:String? = "",
    val password:String? = "",
    val isLoading:Boolean = false,
    val isEmailValid : Boolean? = true,
    val isPasswordValid : Boolean? = true,
    val errorEmailMessage : String = "",
    val errorPasswordMessage : String = ""
)
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
):ViewModel() {

    private var _uiStates = MutableStateFlow(LoginStates())
    val uiStates : StateFlow<LoginStates> = _uiStates.asStateFlow()

    fun onLoginClick()
    {
        Log.d("uiStates",_uiStates.value.toString())
        if(_uiStates.value.email?.isValidEmail()?.not() == false)
        {
            _uiStates.value=_uiStates.value.copy(
                isEmailValid = true
            )
            Log.d("uistateError ",_uiStates.value.isEmailValid.toString())
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

//        if(_uiStates?.value?.isEmailValid && _uiStates.value.isPasswordValid)
//        {
//            //Call login API
//        }
        Log.d("uiStates",_uiStates.value.toString())
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

}