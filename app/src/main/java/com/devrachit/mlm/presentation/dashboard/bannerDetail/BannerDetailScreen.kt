package com.devrachit.mlm.presentation.dashboard.bannerDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import coil.compose.AsyncImage
import com.devrachit.mlm.R
import com.devrachit.mlm.utility.composeUtility.CompletePreviews
import com.devrachit.mlm.utility.composeUtility.OrientationPreviews
import com.devrachit.mlm.utility.composeUtility.sdp
import com.devrachit.mlm.utility.theme.TextStyleInter14Lh16Fw400
import com.devrachit.mlm.utility.theme.TextStyleInter14Lh16Fw600
import com.devrachit.mlm.utility.theme.TextStyleInter16Lh24Fw600
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerDetailScreen() {

    val focusManager = LocalFocusManager.current
    val field1 = remember { mutableStateOf("") }
    val field2 = remember { mutableStateOf("") }
    val field3 = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.surface_card_normal_default)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    )
    {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .background(colorResource(R.color.surface_card_normal_default)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        )
        {
            AsyncImage(
                model = "https://picsum.photos/200/300",
                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                contentDescription = "Carousel Image",
                modifier = Modifier
                    .padding(32.sdp)
                    .clip(RoundedCornerShape(8.sdp))
                    .fillMaxSize()

            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .clip(RoundedCornerShape(topStart = 32.sdp, topEnd = 32.sdp))
                .background(colorResource(R.color.bg_neutral_light_default)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        )
        {
            Row() {
                Column(
                    modifier=Modifier.fillMaxWidth(0.5f)
                        .wrapContentHeight()
                ) {
                    OutlinedTextField(
                        value = field1.value,
                        onValueChange = { field1.value = it },
                        shape = RoundedCornerShape(10.sdp),
                        modifier = Modifier
                            .padding(start = 24.sdp, end = 24.sdp, top = 36.sdp)
                            .fillMaxWidth(),
                        label = {
                            Text(
                                text = "field1",
                                style = TextStyleInter14Lh16Fw400(),
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.sdp))
                                    .background(Color.Transparent)
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        maxLines = 1,
                        isError = false,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = colorResource(id = R.color.bg_accent_light_hover),
                            unfocusedContainerColor = colorResource(id = R.color.bg_accent_light_hover),
                            focusedBorderColor = colorResource(id = R.color.primary_color),
                            unfocusedBorderColor = Color.Transparent,
                            cursorColor = colorResource(id = R.color.primary_color),
                            focusedLabelColor = colorResource(id = R.color.primary_color),
                            unfocusedLabelColor = colorResource(id = R.color.content_neutral_primary_black),
                            focusedTextColor = colorResource(id = R.color.content_neutral_primary_black),
                            unfocusedTextColor = colorResource(id = R.color.content_neutral_primary_black),
                            focusedPlaceholderColor = colorResource(id = R.color.primary_color),
                            unfocusedPlaceholderColor = colorResource(id = R.color.content_neutral_primary_black),
                            errorBorderColor = colorResource(id = R.color.stroke_danger_normal),
                            errorContainerColor = colorResource(id = R.color.bg_accent_light_hover),
                            errorLabelColor = colorResource(id = R.color.stroke_danger_normal),
                        ),

                        )
                    OutlinedTextField(
                        value = field2.value,
                        onValueChange = { field2.value = it },
                        shape = RoundedCornerShape(10.sdp),
                        modifier = Modifier
                            .padding(start = 24.sdp, end = 24.sdp, top = 36.sdp)
                            .fillMaxWidth(),
                        label = {
                            Text(
                                text = "field2",
                                style = TextStyleInter14Lh16Fw400(),
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.sdp))
                                    .background(Color.Transparent)
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        maxLines = 1,
                        isError = false,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = colorResource(id = R.color.bg_accent_light_hover),
                            unfocusedContainerColor = colorResource(id = R.color.bg_accent_light_hover),
                            focusedBorderColor = colorResource(id = R.color.primary_color),
                            unfocusedBorderColor = Color.Transparent,
                            cursorColor = colorResource(id = R.color.primary_color),
                            focusedLabelColor = colorResource(id = R.color.primary_color),
                            unfocusedLabelColor = colorResource(id = R.color.content_neutral_primary_black),
                            focusedTextColor = colorResource(id = R.color.content_neutral_primary_black),
                            unfocusedTextColor = colorResource(id = R.color.content_neutral_primary_black),
                            focusedPlaceholderColor = colorResource(id = R.color.primary_color),
                            unfocusedPlaceholderColor = colorResource(id = R.color.content_neutral_primary_black),
                            errorBorderColor = colorResource(id = R.color.stroke_danger_normal),
                            errorContainerColor = colorResource(id = R.color.bg_accent_light_hover),
                            errorLabelColor = colorResource(id = R.color.stroke_danger_normal),
                        ),

                        )
                    OutlinedTextField(
                        value = field3.value,
                        onValueChange = { field3.value = it },
                        shape = RoundedCornerShape(10.sdp),
                        modifier = Modifier
                            .padding(start = 24.sdp, end = 24.sdp, top = 36.sdp)
                            .fillMaxWidth(),
                        label = {
                            Text(
                                text = "field3",
                                style = TextStyleInter14Lh16Fw400(),
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.sdp))
                                    .background(Color.Transparent)
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        maxLines = 1,
                        isError = false,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = colorResource(id = R.color.bg_accent_light_hover),
                            unfocusedContainerColor = colorResource(id = R.color.bg_accent_light_hover),
                            focusedBorderColor = colorResource(id = R.color.primary_color),
                            unfocusedBorderColor = Color.Transparent,
                            cursorColor = colorResource(id = R.color.primary_color),
                            focusedLabelColor = colorResource(id = R.color.primary_color),
                            unfocusedLabelColor = colorResource(id = R.color.content_neutral_primary_black),
                            focusedTextColor = colorResource(id = R.color.content_neutral_primary_black),
                            unfocusedTextColor = colorResource(id = R.color.content_neutral_primary_black),
                            focusedPlaceholderColor = colorResource(id = R.color.primary_color),
                            unfocusedPlaceholderColor = colorResource(id = R.color.content_neutral_primary_black),
                            errorBorderColor = colorResource(id = R.color.stroke_danger_normal),
                            errorContainerColor = colorResource(id = R.color.bg_accent_light_hover),
                            errorLabelColor = colorResource(id = R.color.stroke_danger_normal),
                        ),

                        )
                }
                val pagerState = rememberPagerState(initialPage = 0)
                val images = listOf(
                    "https://picsum.photos/200/300",
                    "https://picsum.photos/200/300",
                    "https://picsum.photos/200/300",
                    "https://picsum.photos/200/300",
                )
                Box(
                    modifier=Modifier
                        .padding(top=32.sdp, end=32.sdp, start=16.sdp)
                        .fillMaxWidth()
                        .height(280.sdp)
                )
                {
                    HorizontalPager(
                        count = images.size,
                        state = pagerState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.sdp))
                    ) { page ->
                        AsyncImage(
                            model = images[page],
                            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                            contentDescription = "Carousel Image",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(16.sdp))
                                .height(300.sdp)
                        )
                    }

                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.sdp),
                        activeColor = colorResource(R.color.primary_color),
                        inactiveColor = Color.Gray
                    )
                }

            }
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(start = 24.sdp, end = 24.sdp, top = 40.sdp)
                    .height(50.sdp)
                    .widthIn(400.sdp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.primary_color),
                    disabledContainerColor = colorResource(id = R.color.surface_card_normal_default),
                ),
                shape = RoundedCornerShape(10.sdp)
            ) {
                Text(
                    text = "Click Me",
                    color = colorResource(id = R.color.extra_blue_0),
                    style = TextStyleInter16Lh24Fw600()
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.sdp, top = 32.sdp, end = 16.sdp),
                horizontalArrangement = Arrangement.SpaceBetween,
            )
            {
                Text(
                    text = "Rank Banner",
                    style = TextStyleInter14Lh16Fw600(),
                    color = colorResource(R.color.content_neutral_primary_black),
                    modifier = Modifier.padding(start = 16.sdp)
                )
                Text(
                    text = "View All",
                    style = TextStyleInter14Lh16Fw600(),
                    color = colorResource(R.color.primary_color),
                    modifier = Modifier.padding(end = 16.sdp)
                )
            }
            LazyRow(
                modifier = Modifier
                    .padding(start = 16.sdp, end = 16.sdp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                items(7)
                {
                    AsyncImage(
                        model = "https://picsum.photos/200/300",
                        contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                        contentDescription = "Carousel Image",
                        modifier = Modifier
                            .padding(16.sdp)
                            .clip(RoundedCornerShape(8.sdp))
                            .size(90.sdp)

                    )

                }
            }
            Row(
                modifier = Modifier
                    .padding(top = 16.sdp, start=16.sdp, bottom = 32.sdp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                repeat(2)
                {
                    AsyncImage(
                        model = "https://picsum.photos/200/300",
                        contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                        contentDescription = "Carousel Image",
                        modifier = Modifier
                            .padding(16.sdp)
                            .clip(RoundedCornerShape(100.sdp))
                            .size(50.sdp)
                    )
                }
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(start = 24.sdp, end = 24.sdp)
                        .height(50.sdp)
                        .widthIn(400.sdp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.primary_color),
                        disabledContainerColor = colorResource(id = R.color.surface_card_normal_default),
                    ),
                    shape = RoundedCornerShape(10.sdp)
                ) {
                    Text(
                        text = "Click Me",
                        color = colorResource(id = R.color.extra_blue_0),
                        style = TextStyleInter16Lh24Fw600()
                    )
                }
            }
        }

    }

}


@OrientationPreviews
@CompletePreviews
@Composable
fun BannerDetailScreenPreview() {
    BannerDetailScreen()
}