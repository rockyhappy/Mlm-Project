package com.devrachit.mlm.utility.composeUtility

import okhttp3.MultipartBody

fun String.toMultipart(param:String):MultipartBody.Part{
    return MultipartBody.Part.createFormData(param,this)
}