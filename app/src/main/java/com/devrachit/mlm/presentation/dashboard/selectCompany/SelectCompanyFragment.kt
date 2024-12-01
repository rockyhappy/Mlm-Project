package com.devrachit.mlm.presentation.dashboard.selectCompany

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.devrachit.mlm.R
import com.devrachit.mlm.utility.theme.MlmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectCompanyFragment : Fragment() {

    private val viewModel: SelectCompanyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            setContent {

                MlmTheme {
                    val navController = findNavController()
                        SelectCompanyScreen(
                            {navController.navigate(R.id.action_select_company_fragment_to_company_details_fragment)}
                        )
                    }
                }
            }

        }



}