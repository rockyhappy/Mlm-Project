package com.devrachit.mlm.presentation.dashboard.selectCompany

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.devrachit.mlm.R
import com.devrachit.mlm.presentation.dashboard.selectCompany.components.EnhancedAutoCompleteTextField
import com.devrachit.mlm.utility.composeUtility.CompletePreviews
import com.devrachit.mlm.utility.composeUtility.OrientationPreviews
import com.devrachit.mlm.utility.composeUtility.sdp
import com.devrachit.mlm.utility.theme.TextStyleInter16Lh24Fw700
import com.devrachit.mlm.utility.theme.TextStyleInter18Lh24Fw700

@Composable
fun SelectCompanyScreen(
    onItemClick : (String) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .background(colorResource(id = R.color.surface_card_normal_default))
            .fillMaxSize()

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 16.sdp, end = 16.sdp)
                .background(colorResource(id = R.color.surface_card_normal_default)),
        ) {
            Text(
                text = "Select Company",
                color = colorResource(id = R.color.content_neutral_primary_black),
                style = TextStyleInter18Lh24Fw700(),
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                modifier = Modifier
                    .padding(top = 16.sdp, bottom = 16.sdp)
                    .background(colorResource(id = R.color.surface_card_normal_default))
                    .wrapContentSize()

            )
            EnhancedAutoCompleteTextField(
                onItemClick = onItemClick
            )
        }
    }
}

@CompletePreviews
@OrientationPreviews
@Composable
fun SelectCompanyScreenPreview() {
    SelectCompanyScreen(
        onItemClick = {}
    )
}