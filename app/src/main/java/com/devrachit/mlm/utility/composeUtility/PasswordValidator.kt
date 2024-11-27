package com.devrachit.mlm.utility.composeUtility

fun String.isValidPassword() : Boolean {
    val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$".toRegex()
    return passwordPattern.matches(this)
}