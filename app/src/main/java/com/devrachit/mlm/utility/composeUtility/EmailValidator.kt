package com.devrachit.mlm.utility.composeUtility

import android.text.TextUtils
import android.util.Patterns
import java.util.regex.Pattern

//fun CharSequence?.isValidEmail() : Boolean
//{
//
//    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
//
//}
fun isValidEmail(target: CharSequence?): Boolean {
    return if (TextUtils.isEmpty(target)) {
        false
    } else {
        Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}

fun String.isValidEmail(): Boolean {
    val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    return this.isNotBlank() && Regex(emailRegex).matches(this)
}

fun String.isValidMobile(): Boolean {
    val mobileRegex = "^[6-9]\\d{9}$"
    return this.isNotBlank() && Regex(mobileRegex).matches(this)
}