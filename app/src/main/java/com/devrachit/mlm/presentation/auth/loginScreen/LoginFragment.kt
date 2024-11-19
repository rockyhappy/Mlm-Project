package com.devrachit.mlm.presentation.auth.loginScreen

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.devrachit.mlm.R
import com.devrachit.mlm.presentation.auth.splashScreen.SplashScreenLandscape
import com.devrachit.mlm.presentation.auth.splashScreen.SplashScreenPortrait
import com.devrachit.mlm.utility.theme.MlmTheme

class LoginFragment:Fragment(){

    private val viewmodel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            setContent {
                MlmTheme {
                    val navController = findNavController()
                    val configuration = LocalConfiguration.current
                    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

                    if(isLandscape){
                        SplashScreenLandscape(
                            onLoginClick = {
                                navController.navigate(R.id.action_splashFragment_to_loginFragment)
                            },
                            onSignUpClick = {
                                navController.navigate(R.id.action_splashFragment_to_signupFragment)
                            }
                        )
                    }
                    else
                    {
                        LoginScreenPortrait(
                            onLoginClick = {
                                // viewmodel.login()
                            },
                            onSignUpClick = {
                                navController.navigate(R.id.action_loginFragment_to_signupFragment)
                            },
                            onForgotPasswordClick = {
//                                navController.navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
                            },
                            onLoginWithGoogleClick = {
                                // viewmodel.loginWithGoogle()
                            }
                        )

                    }

                }
            }
        }
    }
}