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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.findNavController
import com.devrachit.mlm.R
import com.devrachit.mlm.presentation.auth.splashScreen.SplashScreenLandscape
import com.devrachit.mlm.presentation.auth.splashScreen.SplashScreenPortrait
import com.devrachit.mlm.utility.theme.MlmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                    val uiStates = viewmodel.uiStates.collectAsStateWithLifecycle()
                    if(isLandscape){
                        LoginScreenLandscape(
                            onForgotPasswordClick = {
                                // navController.navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
                            },
                            onLoginClick = viewmodel::onLoginClick,// viewmodel.login(),
                            onSignUpClick = {
                                navController.navigate(R.id.action_loginFragment_to_signupFragment)
                            },
                            onLoginWithGoogleClick = {
                                // viewmodel.loginWithGoogle()
                            }
                        )
                    }
                    else
                    {
                        LoginScreenPortrait(
                            uiStates = uiStates.value,
                            onLoginClick =  viewmodel::onLoginClick,
                            onSignUpClick = {
                                navController.navigate(R.id.action_loginFragment_to_signupFragment)
                            },
                            onForgotPasswordClick = {
//                                navController.navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
                            },
                            onLoginWithGoogleClick = {
                                // viewmodel.loginWithGoogle()
                            },
                            setEmail =viewmodel::setEmail,
                            setPassword = viewmodel::setPassword
                        )

                    }

                }
            }
        }
    }
}