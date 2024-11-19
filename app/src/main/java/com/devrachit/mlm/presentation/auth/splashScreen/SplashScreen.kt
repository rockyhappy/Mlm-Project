package com.devrachit.mlm.presentation.auth.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Image
import com.devrachit.mlm.R
import com.devrachit.mlm.utility.composeUtility.CompletePreviews
import com.devrachit.mlm.utility.composeUtility.sdp
import com.devrachit.mlm.utility.composeUtility.ssp
import com.devrachit.mlm.utility.theme.TextStyleInter12Lh16Fw600
import com.devrachit.mlm.utility.theme.TextStyleInter14Lh16Fw400
import com.devrachit.mlm.utility.theme.TextStyleInter16Lh24Fw600
import com.devrachit.mlm.utility.theme.TextStyleInter18Lh24Fw700


@Composable
fun SplashScreen(
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(colorResource(id = R.color.surface_card_normal_default)),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(top = 50.sdp)
                .weight(0.5f)
                .padding(start = 22.sdp, end = 22.sdp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.filler_person1),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "Splash Screen Image"
            )
        }
        Column(
            modifier = Modifier
                .weight(0.6f)
                .fillMaxSize()
                .padding(start = 22.sdp, end = 22.sdp),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly

            )
        {
            Text(
                text = "Your Own Personalized \n Advertisement Creator",
                color = colorResource(id = R.color.primary_color),
                fontSize = 24.ssp,
                fontFamily = TextStyleInter18Lh24Fw700().fontFamily,
                fontWeight = TextStyleInter18Lh24Fw700().fontWeight,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                maxLines = 2,
                lineHeight = 28.ssp,
                modifier = Modifier

            )
            Text(
                text = "Create your own personalized advertisement \n in just a few clicks",
                color = colorResource(id = R.color.content_neutral_primary_black),
                style= TextStyleInter14Lh16Fw400(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                maxLines = 2,
                modifier = Modifier
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceAround
            )
            {
                Button(
                    onClick = onLoginClick,
                    modifier= Modifier
                        .height(50.sdp)
                        .width(130.sdp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.primary_color),
                        disabledContainerColor = colorResource(id = R.color.surface_card_normal_default),
                    ),
                    shape = RoundedCornerShape(10.sdp)
                ) {
                    Text(
                        text = "Login",
                        color = colorResource(id = R.color.extra_blue_0),
                        style= TextStyleInter16Lh24Fw600()
                    )
                }
                Button(
                    onClick = onSignUpClick,
                    modifier= Modifier
                        .height(50.sdp)
                        .width(130.sdp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.bg_neutral_light_default),
                        disabledContainerColor = colorResource(id = R.color.surface_card_normal_default),
                    ),
                    shape = RoundedCornerShape(10.sdp)
                ) {
                    Text(
                        text = "Sign Up",
                        color = colorResource(id = R.color.content_neutral_primary_black),
                        style= TextStyleInter16Lh24Fw600()
                    )
                }
            }
        }


    }


}

@CompletePreviews
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}