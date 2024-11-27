package com.devrachit.mlm.presentation.auth.forgotPasswordScreen

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
import com.devrachit.mlm.utility.theme.MlmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment : Fragment() {

    private val viewModel: ForgotPasswordViewModel by viewModels()

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
                    val uiStates = viewModel.uiStates.collectAsStateWithLifecycle()
                    if(isLandscape) {

                        ForgotPasswordScreenLandscape(
                            uiStates = uiStates.value,
                            onForgotPasswordClick = {viewModel::onForgotPasswordClick;
                                                    navController.navigate(R.id.action_forgetPasswordFragment_to_otpFragment)},
                            setEmail = viewModel::setEmail
                        )
                    }
                    else{
                        ForgotPasswordScreen(
                            uiStates = uiStates.value,
                            onForgotPasswordClick = {viewModel::onForgotPasswordClick;
                                                    navController.navigate(R.id.action_forgetPasswordFragment_to_otpFragment)},
                            setEmail = viewModel::setEmail
                        )
                    }

                }

            }
        }

    }

}