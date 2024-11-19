package com.devrachit.mlm.presentation.auth.splashScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.devrachit.mlm.R
import com.devrachit.mlm.utility.theme.MlmTheme
import dagger.hilt.android.AndroidEntryPoint

//import com.devrachit.mlm.utility.theme.MlmTheme

@AndroidEntryPoint
class SplashFragment:Fragment() {
    private val viewmodel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            val navController = findNavController()
            setContent {
                MlmTheme {
                    SplashScreen(
                        onLoginClick = {
                            navController.navigate(R.id.action_splashFragment_to_loginFragment)
                        },
                        onSignUpClick = {
                            navController.navigate(R.id.action_splashFragment_to_signupFragment)
                        }
                    )
                }
            }
        }
    }

}