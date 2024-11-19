package com.devrachit.mlm.utility.composeUtility


import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "phone",
    group = "devices",
    device = "spec:width=360dp,height=640dp,dpi=480"
)
@Preview(
    name = "tablet",
    group = "devices",
    device = "spec:width=800dp,height=1280dp,dpi=480"
)
annotation class DevicePreviews


@Preview(
    name = "light theme",
    group = "themes",
    showBackground = true
)
@Preview(
    name = "dark theme",
    group = "themes",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
)
annotation class ThemesPreview


@DevicePreviews
@ThemesPreview
annotation class CompletePreviews