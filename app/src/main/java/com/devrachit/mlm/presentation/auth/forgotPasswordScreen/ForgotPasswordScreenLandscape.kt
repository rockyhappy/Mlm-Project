package com.devrachit.mlm.presentation.auth.forgotPasswordScreen

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.findNavController
import com.devrachit.mlm.utility.composeUtility.OrientationPreviews
import com.devrachit.mlm.utility.theme.MlmTheme
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun ForgotPasswordScreenLandscape(
    uiStates: ForgotPasswordStates,
    onForgotPasswordClick: () -> Unit,
    setEmail: (String) -> Unit
) {

}
@OrientationPreviews
@Composable
fun preview()
{
    ForgotPasswordScreenLandscape(
        uiStates = ForgotPasswordStates(),
        onForgotPasswordClick = {},
        setEmail = {}
    )
}