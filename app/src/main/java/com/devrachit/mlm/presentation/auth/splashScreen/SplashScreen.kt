package com.devrachit.mlm.presentation.auth.splashScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.devrachit.mlm.utility.composeUtility.CompletePreviews
import com.devrachit.mlm.utility.composeUtility.ssp


@Composable
fun SplashScreen()
{

        Text(
            text="Hello World",
            color = Color.White,
            modifier = Modifier.fillMaxSize(),
            fontSize = 30.ssp
        )


}

@CompletePreviews
@Composable
fun SplashScreenPreview()
{
    SplashScreen()
}