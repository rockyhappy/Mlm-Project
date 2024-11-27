package com.devrachit.mlm.presentation.auth.forgotPasswordScreen

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.findNavController
import com.devrachit.mlm.R
import com.devrachit.mlm.utility.composeUtility.OrientationPreviews
import com.devrachit.mlm.utility.composeUtility.sdp
import com.devrachit.mlm.utility.composeUtility.ssp
import com.devrachit.mlm.utility.theme.MlmTheme
import com.devrachit.mlm.utility.theme.TextStyleInter12Lh16Fw400
import com.devrachit.mlm.utility.theme.TextStyleInter12Lh16Fw500
import com.devrachit.mlm.utility.theme.TextStyleInter14Lh16Fw400
import com.devrachit.mlm.utility.theme.TextStyleInter16Lh24Fw600
import com.devrachit.mlm.utility.theme.TextStyleInter16Lh24Fw700
import com.devrachit.mlm.utility.theme.TextStyleInter18Lh24Fw700
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun ForgotPasswordScreenLandscape(
    uiStates: ForgotPasswordStates,
    onForgotPasswordClick: () -> Unit,
    setEmail: (String) -> Unit
) {

    Row(
        modifier= Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.surface_card_normal_default)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    )
    {
        Column(
            modifier= Modifier.weight(0.35f).padding(start=22.sdp,end=22.sdp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "Forgot Password",
                color = colorResource(id = R.color.primary_color),
                fontSize = 24.ssp,
                fontFamily = TextStyleInter18Lh24Fw700().fontFamily,
                fontWeight = TextStyleInter18Lh24Fw700().fontWeight,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                lineHeight = 28.ssp,
                modifier = Modifier

            )
            Text(
                text = "Enter your email address \n" +
                        "to reset your password",
                color = colorResource(id = R.color.content_neutral_primary_black),
                style = TextStyleInter16Lh24Fw700(),
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                modifier = Modifier.padding(top = 10.sdp)
            )
        }
        Column(
            modifier= Modifier.weight(0.65f).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        )
        {
            val focusManager = LocalFocusManager.current
            Column {
                OutlinedTextField(
                    value = uiStates?.email ?: "",
                    onValueChange = { setEmail(it) },
                    shape = RoundedCornerShape(10.sdp),
                    modifier = Modifier
                        .padding(start = 24.sdp, end = 24.sdp, top = 10.sdp)
                        .widthIn(400.sdp),
                    label = {
                        Text(
                            text = "Email",
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
                    isError = uiStates?.isEmailValid == false,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = colorResource(id = R.color.bg_neutral_light_default),
                        unfocusedContainerColor = colorResource(id = R.color.bg_neutral_light_default),
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
                        errorContainerColor = colorResource(id = R.color.bg_neutral_light_default),
                        errorLabelColor = colorResource(id = R.color.stroke_danger_normal),
                    )
                )
                if (uiStates?.isEmailValid == false)
                    Text(
                        text = uiStates.errorEmailMessage,
                        color = colorResource(id = R.color.stroke_danger_normal),
                        style = TextStyleInter12Lh16Fw400(),
                        modifier = Modifier
                            .padding(start = 24.sdp, end = 24.sdp, top=8.sdp)
                            .align(Alignment.Start),
                    )
            }

//            Row(
//                modifier= Modifier
//                    .widthIn(400.sdp)
//                    .padding(end = 24.sdp),
//                horizontalArrangement = Arrangement.End,
//                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
//            ){
//                Text(
//                    text = "Forgot Password?",
//                    color = colorResource(id = R.color.primary_color),
//                    style = TextStyleInter16Lh24Fw600(),
//                    modifier = Modifier
//                        .padding(top = 10.sdp)
//                        .clickable { onForgotPasswordClick() }
//                )
//            }

            Button(
                onClick = onForgotPasswordClick,
                modifier= Modifier
                    .padding(start = 24.sdp, end = 24.sdp, top = 10.sdp)
                    .height(50.sdp)
                    .widthIn(400.sdp),
                colors = ButtonDefaults.buttonColors(
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
            Text(
                text="An email will be sent to you\n with instructions on how to \nreset your password",
                color = colorResource(id = R.color.content_neutral_primary_black),
                style = TextStyleInter12Lh16Fw500(),
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3,
                modifier = Modifier
                    .padding(top = 30.sdp)

            )

        }
    }
}
@OrientationPreviews
@Composable
fun preview()
{
    ForgotPasswordScreenLandscape(
        uiStates = ForgotPasswordStates(),
        onForgotPasswordClick = {},
        setEmail = {}
    )
}