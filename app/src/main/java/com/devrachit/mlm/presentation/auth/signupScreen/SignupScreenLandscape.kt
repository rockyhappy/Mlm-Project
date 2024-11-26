package com.devrachit.mlm.presentation.auth.signupScreen

import androidx.compose.runtime.Composable
import com.devrachit.mlm.presentation.auth.loginScreen.LoginStates

@Composable
fun SignupScreenLandscape(
    uiStates: SignupStates? = SignupStates(),
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    onLoginWithGoogleClick: () -> Unit = {},
    setEmail: (String) -> Unit = {},
    setPassword: (String) -> Unit = {},
    setConfirmPassword: (String) -> Unit = {}
)
{

}