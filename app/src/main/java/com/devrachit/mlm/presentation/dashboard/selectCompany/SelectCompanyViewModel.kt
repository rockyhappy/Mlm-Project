package com.devrachit.mlm.presentation.dashboard.selectCompany

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



data class SelectCompanyStates(
    val companyName:String? = "",
    val companyCode:String? = "",
    val isLoading:Boolean = false,
    val isCompanyNameValid : Boolean? = true,
    val isCompanyCodeValid : Boolean? = true,
    val errorCompanyNameMessage : String = "",
    val errorCompanyCodeMessage : String = ""
)
@HiltViewModel
class SelectCompanyViewModel @Inject constructor() : ViewModel()
{

}