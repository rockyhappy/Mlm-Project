package com.devrachit.mlm.presentation.dashboard.companyDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.devrachit.mlm.R

import com.devrachit.mlm.utility.theme.MlmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompanyDetailsFragment : Fragment(){

    private val viewModel: CompanyDetailsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            setContent {
                MlmTheme {
                    val navController = findNavController()
                    CompanyDetailsScreen(
                        {navController.navigate(R.id.action_company_details_fragment_to_viewAllBannersFragment)},
                        {navController.navigate(R.id.action_company_details_fragment_to_viewAllBannersFragment)}
                    )
                }
            }
        }

    }

}