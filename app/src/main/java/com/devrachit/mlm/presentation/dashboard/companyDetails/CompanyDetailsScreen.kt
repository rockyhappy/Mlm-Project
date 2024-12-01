package com.devrachit.mlm.presentation.dashboard.companyDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.devrachit.mlm.R
import com.devrachit.mlm.utility.composeUtility.CompletePreviews
import com.devrachit.mlm.utility.composeUtility.OrientationPreviews
import com.devrachit.mlm.utility.composeUtility.sdp
import com.devrachit.mlm.utility.composeUtility.ssp
import com.devrachit.mlm.utility.theme.TextStyleInter14Lh16Fw600
import com.devrachit.mlm.utility.theme.TextStyleInter24Lh36Fw600
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CompanyDetailsScreen(
    onItemClick: (String) -> Unit,
    onViewAllClick : (String) -> Unit
) {

    val pagerState = rememberPagerState(initialPage = 0)
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
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Text(
                text = "Company Details",
                style = TextStyleInter24Lh36Fw600(),
                color = colorResource(R.color.content_neutral_primary_black),
                modifier = Modifier.padding(16.sdp)
            )
            Spacer(modifier = Modifier.weight(1f))
            AsyncImage(
                model = "https://i.postimg.cc/Kc1Zv1x7/search-1.png",
                contentDescription = null,
                modifier = Modifier
                    .padding(16.sdp)
                    .height(36.sdp)
            )
            AsyncImage(
                model = "https://i.postimg.cc/Kc1Zv1x7/search-1.png",
                contentDescription = null,
                modifier = Modifier
                    .padding(16.sdp)
                    .height(36.sdp)
            )
        }
        val images = listOf(
            "https://picsum.photos/200/300",
            "https://picsum.photos/200/300",
            "https://picsum.photos/200/300",
            "https://picsum.photos/200/300",
        )
        Box(
            modifier = Modifier
                .padding(top = 16.sdp)
                .fillMaxWidth(0.75f)
                .fillMaxHeight(0.4f)
                .clip(RoundedCornerShape(16.sdp))
                .background(colorResource(R.color.surface_card_normal_default))
        ) {

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
                        .height(300.sdp).clickable { onItemClick("Company Details") }
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
        Row(
            modifier = Modifier
                .padding(top = 16.sdp)
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            repeat(3)
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
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.sdp),
        )
        {
            Text(
                text = "Calender",
                style = TextStyleInter14Lh16Fw600(),
                color = colorResource(R.color.content_neutral_primary_black),
                modifier = Modifier.padding(start = 16.sdp)
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
            item {
                Box(
                    modifier = Modifier
                        .padding(10.sdp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 16.sdp,
                                topEnd = 0.sdp,
                                bottomEnd = 16.sdp,
                                bottomStart = 0.sdp
                            )
                        )
                        .background(colorResource(R.color.primary_color))
                        .size(50.sdp)
                )
                {
                    Text(
                        text = "  2\nJan",
                        style = TextStyleInter14Lh16Fw600(),
                        color = colorResource(R.color.content_neutral_primary_black),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            items(7)
            {
                Box(
                    modifier = Modifier
                        .padding(10.sdp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 16.sdp,
                                topEnd = 0.sdp,
                                bottomEnd = 16.sdp,
                                bottomStart = 0.sdp
                            )
                        )
                        .background(colorResource(R.color.bg_neutral_light_default))
                        .size(50.sdp)
                )
                {
                    Text(
                        text = "  1\nJan",
                        style = TextStyleInter14Lh16Fw600(),
                        color = colorResource(R.color.content_neutral_primary_black),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

            }
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
                            .clickable { onItemClick("Company Details") }
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
            Text(
                text = "View All",
                style = TextStyleInter14Lh16Fw600(),
                color = colorResource(R.color.primary_color),
                modifier = Modifier.padding(end = 16.sdp).clickable { onViewAllClick("Rank Banner") }
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
                        .clickable { onItemClick("Company Details") }
                )

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
            Text(
                text = "View All",
                style = TextStyleInter14Lh16Fw600(),
                color = colorResource(R.color.primary_color),
                modifier = Modifier.padding(end = 16.sdp).clickable { onViewAllClick("Motivation Banner") }
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
                        .clickable { onItemClick("Company Details") }
                )

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
            Text(
                text = "View All",
                style = TextStyleInter14Lh16Fw600(),
                color = colorResource(R.color.primary_color),
                modifier = Modifier.padding(end = 16.sdp).clickable { onViewAllClick("Motivation Banner") }
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
                        .clickable { onItemClick("Company Details") }
                )

            }
        }


    }

}

@CompletePreviews
@OrientationPreviews
@Composable
fun CompanyDetailsScreenPreview() {
    CompanyDetailsScreen(
        {},
        {}
    )
}

