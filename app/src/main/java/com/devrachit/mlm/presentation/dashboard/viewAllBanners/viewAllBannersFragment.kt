package com.devrachit.mlm.presentation.dashboard.viewAllBanners

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.devrachit.mlm.utility.theme.MlmTheme


@AndroidEntryPoint
class ViewAllBannersFragment : Fragment(){

    private val viewModel: ViewAllBannersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            setContent {
                MlmTheme {
                    ViewAllBannersScreen()
                }
            }
        }

    }
}