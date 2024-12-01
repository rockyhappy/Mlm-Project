package com.devrachit.mlm.presentation.dashboard.selectCompany.components


import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Chip
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.devrachit.mlm.R
import com.devrachit.mlm.utility.composeUtility.CompletePreviews
import com.devrachit.mlm.utility.composeUtility.sdp
import com.devrachit.mlm.utility.composeUtility.ssp
import com.devrachit.mlm.utility.theme.TextStyleInter10Lh12Fw400
import com.devrachit.mlm.utility.theme.TextStyleInter12Lh16Fw400
import com.devrachit.mlm.utility.theme.TextStyleInter16Lh24Fw700

data class Company(
    val name: String,
    val logoUrl: String,
    val category1: String,
    val category2: String
)


@Composable
fun EnhancedAutoCompleteTextField(
    onItemClick: (String) -> Unit
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    val suggestions = listOf(
        Company(
            "Apple",
            "https://www.apple.com/ac/structured-data/images/knowledge_graph_logo.png?202110180743",
            "Innovative",
            "Reliable"
        ),
        Company(
            "Google",
            "https://i.postimg.cc/Kc1Zv1x7/search-1.png",
            "Search",
            "Technology"
        ),
        Company(
            "Microsoft",
            "https://i.postimg.cc/y8tmtg1f/microsoft.png",
            "Software",
            "Cloud"
        ),
        Company(
            "Amazon",
            "https://i.postimg.cc/j2yqx1Pw/social.png",
            "E-commerce",
            "Cloud"
        ),
        Company(
            "Facebook",
            "https://www.facebook.com/images/fb_icon_325x325.png",
            "Social",
            "Media"
        ),
        Company(
            "Tesla",
            "https://i.postimg.cc/KjbSN83j/brand.png",
            "Electric",
            "Cars"
        ),
        Company(
            "Netflix",
            "https://assets.nflxext.com/us/ffe/siteui/common/icons/nficon2016.png",
            "Streaming",
            "Entertainment"
        ),
        Company(
            "Spotify",
            "https://i.postimg.cc/QMjTRQLJ/spotify.png",
            "Music",
            "Streaming"
        ),
        Company(
            "Twitter",
            "https://abs.twimg.com/icons/apple-touch-icon-192x192.png",
            "Social",
            "Media"
        ),
        Company(
            "Uber",
            "https://i.postimg.cc/D07fzggx/uber.png",
            "Ride",
            "Sharing"
        ),
        Company(
            "Adobe",
            "https://i.postimg.cc/0Qb1pVm3/adobe.png",
            "Creativity",
            "Software"
        ),
        Company(
            "IBM",
            "https://i.postimg.cc/R0Wg0LhQ/ibm.png",
            "Enterprise",
            "Technology"
        ),
        Company(
            "Intel",
            "https://i.postimg.cc/MTTgVn3n/intel.png",
            "Processors",
            "Hardware"
        ),
        Company(
            "Cisco",
            "https://i.postimg.cc/wj71yy30/cisco.png",
            "Networking",
            "Technology"
        ),
        Company(
            "Oracle",
            "https://i.postimg.cc/kGdzbVhN/oracle.png",
            "Database",
            "Software"
        ),
        Company(
            "Samsung",
            "https://i.postimg.cc/3wCwYgtM/samsung.png",
            "Electronics",
            "Innovation"
        ),
        Company(
            "PayPal",
            "https://i.postimg.cc/pVZdWcK7/paypal.png",
            "Payments",
            "Finance"
        ),
        Company(
            "Airbnb",
            "https://i.postimg.cc/0QbnzJ4Z/airbnb.png",
            "Travel",
            "Hospitality"
        ),
        Company(
            "SpaceX",
            "https://i.postimg.cc/yxg6Lh8V/spacex.png",
            "Aerospace",
            "Innovation"
        ),
        Company(
            "Slack",
            "https://i.postimg.cc/gj0FD2tN/slack.png",
            "Communication",
            "Collaboration"
        )
    )

    var filteredSuggestions by remember { mutableStateOf(suggestions) }
    var showSuggestions by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.surface_card_normal_default)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.sdp, RoundedCornerShape(8.sdp)),
            shape = RoundedCornerShape(8.sdp),
            elevation = CardDefaults.cardElevation(8.sdp)
        ) {
            BasicTextField(
                value = textFieldValue,
                onValueChange = { newValue ->
                    if (newValue.text != textFieldValue.text) {
                        textFieldValue = newValue
                        showSuggestions = newValue.text.isNotEmpty()
                        filteredSuggestions = if (newValue.text.isEmpty()) {
                            suggestions
                        } else {
                            suggestions.filter {
                                it.name.contains(
                                    newValue.text,
                                    ignoreCase = true
                                )
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.bg_neutral_light_default))
                    .padding(16.sdp)
                    .focusRequester(focusRequester),
                textStyle = TextStyle(color = Color.Black, fontSize = 18.ssp),
                cursorBrush = SolidColor(Color.Blue),
                decorationBox = { innerTextField ->
                    if (textFieldValue.text.isEmpty()) {
                        Text(
                            text = "Enter Fruit...",
                            style = TextStyle(color = Color.Gray, fontSize = 18.ssp)
                        )
                    }
                    innerTextField()
                },

                )
        }
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
        Spacer(modifier = Modifier.height(8.sdp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.sdp, RoundedCornerShape(8.sdp))
                .background(
                    color = colorResource(R.color.surface_card_normal_default),
                    shape = RoundedCornerShape(8.sdp)
                )
                .animateContentSize()
        ) {
            if (filteredSuggestions.isNotEmpty()) {
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxWidth(),
                    columns = GridCells.Fixed(2),
                ) {
                    items(
                        filteredSuggestions.size,
                        key = { suggestion -> suggestion },

                    ) {
                        InnerElement(filteredSuggestions[it], onItemClick)

                    }
                }
            } else if (filteredSuggestions.isEmpty()) {
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxWidth(),
                    columns = GridCells.Fixed(2),
                ) {
                    items(
                        suggestions.size,
                        key = { suggestion -> suggestion }
                    ) {
                        InnerElement(suggestions[it],onItemClick)

                    }
                }
            }
        }
    }
}


@Composable
fun InnerElement(company: Company, onItemClick: (String) -> Unit = {}) {
    Column(
        modifier = Modifier
            .padding(start = 8.sdp, end = 8.sdp, top = 8.sdp, bottom = 8.sdp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.sdp))
            .background(colorResource(R.color.bg_neutral_light_default))
            .clickable {
                onItemClick(company.name)
            }
    )
    {
        Row(

        )
        {
            Text(
                text = company.name,
                color = colorResource(id = R.color.content_neutral_primary_black),
                style = TextStyleInter16Lh24Fw700(),
                modifier = Modifier.padding(start = 8.sdp, top = 8.sdp, bottom = 8.sdp)
            )
        }
        Row()
        {
            Column(
                modifier=Modifier.padding(start=8.sdp, end=8.sdp, top=8.sdp, bottom=8.sdp),
                verticalArrangement = Arrangement.spacedBy(4.sdp),
                horizontalAlignment = Alignment.Start
            )
            {
                Text(
                    text = company.category1,
                    color = colorResource(id = R.color.content_neutral_primary_black),
                    style = TextStyleInter10Lh12Fw400(),
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.sdp))
                        .background(colorResource(R.color.bg_accent_light_hover))
                        .wrapContentSize()
                        .padding(start=6.sdp, end=6.sdp, top=4.sdp, bottom=4.sdp)
                )
                Text(
                    text = company.category2,
                    color = colorResource(id = R.color.content_neutral_primary_black),
                    style = TextStyleInter10Lh12Fw400(),
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.sdp))
                        .background(colorResource(R.color.bg_accent_light_hover))
                        .wrapContentSize()
                        .padding(start=6.sdp, end=6.sdp, top=4.sdp, bottom=4.sdp)
                )

            }
            AsyncImage(
                model = company.logoUrl,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.sdp)
                    .fillMaxWidth()
                    .height(70.sdp)
            )
        }
    }
}

@CompletePreviews
@Composable
fun EnhancedAutoCompleteTextFieldPreview() {
    InnerElement(
        Company(
            "Apple",
            "https://www.apple.com/ac/structured-data/images/knowledge_graph_logo.png?202110180743",
            "Innovative",
            "Reliable"
        )
    )
}



