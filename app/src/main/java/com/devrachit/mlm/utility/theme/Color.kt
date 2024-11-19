package com.devrachit.mlm.utility.theme


import androidx.compose.ui.graphics.Color

fun Color.Companion.toColor(colorString: String) = Color(android.graphics.Color.parseColor(colorString))