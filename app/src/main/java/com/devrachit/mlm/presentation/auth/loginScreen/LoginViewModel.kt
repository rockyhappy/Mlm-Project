package com.devrachit.mlm.presentation.auth.loginScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.devrachit.mlm.data.local.DataStoreRepository
import com.devrachit.mlm.data.remote.ApiServices
import com.devrachit.mlm.data.remote.dto.RegisterResponseDto
import com.devrachit.mlm.utility.composeUtility.isValidEmail
import com.devrachit.mlm.utility.composeUtility.isValidPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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
    val errorPasswordMessage : String = ""
)
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,

):ViewModel() {
    init {
        Log.d("LoginViewModel","LoginViewModel created")
        val retrofit = Retrofit.Builder()
            .baseUrl("https://adsmaker.edumakers.online/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiServices::class.java)

        val name = MultipartBody.Part.createFormData("name", "rachit")
        val password = MultipartBody.Part.createFormData("password", "12345")
        val mobile = MultipartBody.Part.createFormData("mobile", "9368053101")
        val action = MultipartBody.Part.createFormData("action", "register")
        val email = MultipartBody.Part.createFormData("email", "rachit.katiyar@mathongo.com")

//        val call = apiService.registerUser(authorization = "Bearer adss548557",name= name, password=password, mobile=mobile, action=action,email= email)
//    call.enqueue(object : Callback<RegisterResponseDto> {
//    override fun onResponse(call: Call<RegisterResponseDto>, response: Response<RegisterResponseDto>) {
//        if (response.isSuccessful) {
//                    Log.d("API_CALL", response.body().toString())
//                } else {
//                    Log.e("API_CALL", "Error: ${response.code()} - ${response.errorBody()}")
//                }
//            }
//
//            override fun onFailure(call: Call<RegisterResponseDto>, t: Throwable) {
//                Log.e("API_CALL", "Failure: ${t.message}")
//            }
//        })
    }

    private var _uiStates = MutableStateFlow(LoginStates())
    val uiStates : StateFlow<LoginStates> = _uiStates.asStateFlow()

    fun onLoginClick()
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
        Log.d("onLoginClick",_uiStates.value.toString())

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