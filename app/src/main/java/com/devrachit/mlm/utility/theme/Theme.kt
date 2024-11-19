package com.devrachit.mlm.utility.theme

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import dagger.hilt.android.internal.managers.ViewComponentManager

private val LightColorScheme = lightColorScheme(

)

private val DarkColorScheme = darkColorScheme(

)
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MlmTheme(
//    darkTheme: Boolean = isNightMode(),
//    dynamicColor: Boolean = false,
//    content: @Composable () -> Unit
//) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }
//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//
//            val window = view.context.asActivity().window
////            window.statusBarColor = Color.White.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
//        }
//    }
//
//    CompositionLocalProvider(
//        LocalMinimumInteractiveComponentEnforcement provides false
//    ) {
//        MaterialTheme(
//            colorScheme = colorScheme,
//            content = content,
//            typography = Typography
//        )
//    }
//
//}
//fun Context.asActivity(): Activity {
//    return if (this is ViewComponentManager.FragmentContextWrapper) {
//        this.baseContext as Activity
//    } else this as Activity
//}
//
//
//@Composable
//private fun isNightMode() = when (AppCompatDelegate.getDefaultNightMode()) {
//    AppCompatDelegate.MODE_NIGHT_NO -> false
//    AppCompatDelegate.MODE_NIGHT_YES -> true
//    else -> isSystemInDarkTheme()
//}