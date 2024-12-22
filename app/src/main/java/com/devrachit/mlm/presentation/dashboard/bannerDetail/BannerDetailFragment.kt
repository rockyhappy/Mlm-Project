package com.devrachit.mlm.presentation.dashboard.bannerDetail

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.devrachit.mlm.R
import com.devrachit.mlm.utility.theme.MlmTheme

@AndroidEntryPoint
class BannerDetailFragment: Fragment() {

        private val viewModel: BannerDetailViewModel by viewModels()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return ComposeView(requireContext()).apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

                setContent {
                    MlmTheme {
                        BannerDetailScreen()
                    }
                }
            }

        }
}