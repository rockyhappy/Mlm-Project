package com.devrachit.mlm.presentation.dashboard.viewAllBanners

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import coil.compose.AsyncImage
import com.devrachit.mlm.R
import com.devrachit.mlm.utility.composeUtility.CompletePreviews
import com.devrachit.mlm.utility.composeUtility.OrientationPreviews
import com.devrachit.mlm.utility.composeUtility.sdp
import com.devrachit.mlm.utility.theme.TextStyleInter14Lh16Fw600

@Composable
fun ViewAllBannersScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(colorResource(R.color.surface_card_normal_default))
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.sdp, top = 16.sdp, end = 16.sdp),
            horizontalArrangement = Arrangement.SpaceBetween,
        )
        {
            Text(
                text = "Heading Banner",
                style = TextStyleInter14Lh16Fw600(),
                color = colorResource(R.color.content_neutral_primary_black),
                modifier = Modifier.padding(start = 16.sdp)
            )
//            Text(
//                text = "View All",
//                style = TextStyleInter14Lh16Fw600(),
//                color = colorResource(R.color.primary_color),
//                modifier = Modifier.padding(end = 16.sdp).clickable { onViewAllClick("Rank Banner") }
//            )
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
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.sdp))
                        .wrapContentSize(),
                    contentAlignment = Alignment.BottomEnd
                )
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
                    Text(
                        text = "21",
                        style = TextStyleInter14Lh16Fw600(),
                        color = colorResource(R.color.content_neutral_primary_black),
                        modifier = Modifier
                            .padding(16.sdp)
                            .clip(RoundedCornerShape(topStart = 6.sdp, bottomEnd = 6.sdp))
                            .background(colorResource(R.color.primary_color))
                            .padding(4.sdp)
                    )
                }


            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.sdp, top = 16.sdp, end = 16.sdp),
            horizontalArrangement = Arrangement.SpaceBetween,
        )
        {
            Text(
                text = "Rank Banner",
                style = TextStyleInter14Lh16Fw600(),
                color = colorResource(R.color.content_neutral_primary_black),
                modifier = Modifier.padding(start = 16.sdp)
            )
//            Text(
//                text = "View All",
//                style = TextStyleInter14Lh16Fw600(),
//                color = colorResource(R.color.primary_color),
//                modifier = Modifier.padding(end = 16.sdp).clickable { onViewAllClick("Rank Banner") }
//            )
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
                Column {
                    AsyncImage(
                        model = "https://picsum.photos/200/300",
                        contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                        contentDescription = "Carousel Image",
                        modifier = Modifier
                            .padding(16.sdp)
                            .clip(RoundedCornerShape(8.sdp))
                            .size(90.sdp)
                    )

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
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.sdp, top = 16.sdp, end = 16.sdp),
            horizontalArrangement = Arrangement.SpaceBetween,
        )
        {
            Text(
                text = "Motivation Banner",
                style = TextStyleInter14Lh16Fw600(),
                color = colorResource(R.color.content_neutral_primary_black),
                modifier = Modifier.padding(start = 16.sdp)
            )
//            Text(
//                text = "View All",
//                style = TextStyleInter14Lh16Fw600(),
//                color = colorResource(R.color.primary_color),
//                modifier = Modifier.padding(end = 16.sdp)
//            )
        }
        LazyRow (
            modifier = Modifier
                .padding(start = 16.sdp, end = 16.sdp)
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            items(14)
            {
                Column {
                    AsyncImage(
                        model = "https://picsum.photos/200/300",
                        contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                        contentDescription = "Carousel Image",
                        modifier = Modifier
                            .padding(16.sdp)
                            .clip(RoundedCornerShape(8.sdp))
                            .size(90.sdp)
                    )
                    AsyncImage(
                        model = "https://picsum.photos/200/300",
                        contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                        contentDescription = "Carousel Image",
                        modifier = Modifier
                            .padding(16.sdp)
                            .clip(RoundedCornerShape(8.sdp))
                            .size(90.sdp)
                    )
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
        }
    }
}

@CompletePreviews
@OrientationPreviews
@Composable
fun ViewAllBannersScreenPreview() {
    ViewAllBannersScreen()
}