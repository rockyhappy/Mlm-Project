package com.devrachit.mlm.presentation.auth.splashScreen

import androidx.lifecycle.ViewModel
import com.devrachit.mlm.data.local.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel  @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
) :ViewModel() {
}