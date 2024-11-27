package com.devrachit.mlm.presentation.auth.otpScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.devrachit.mlm.R
import com.devrachit.mlm.utility.composeUtility.CompletePreviews
import com.devrachit.mlm.utility.composeUtility.sdp
import com.devrachit.mlm.utility.composeUtility.ssp
import com.devrachit.mlm.utility.theme.TextStyleInter12Lh16Fw400
import com.devrachit.mlm.utility.theme.TextStyleInter12Lh16Fw500
import com.devrachit.mlm.utility.theme.TextStyleInter14Lh16Fw400
import com.devrachit.mlm.utility.theme.TextStyleInter16Lh24Fw600
import com.devrachit.mlm.utility.theme.TextStyleInter16Lh24Fw700
import com.devrachit.mlm.utility.theme.TextStyleInter18Lh24Fw700

@Composable
fun OtpScreenPortrait(
    uiStates: OtpStates,
    onOtpChange: (String) -> Unit,
    onOtpClick: (String) -> Unit,
    onResendOtpClick: () -> Unit,
    
)
{
    var otp1 by remember { mutableStateOf("") }
    var otp2 by remember { mutableStateOf("") }
    var otp3 by remember { mutableStateOf("") }
    var otp4 by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.surface_card_normal_default)),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    )
    {
        Column(
            modifier = Modifier
                .weight(0.25f)
                .fillMaxSize()
                .padding(start = 22.sdp, end = 22.sdp, top = 60.sdp),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center

        )
        {

            Text(
                text = "Enter OTP",
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
                text = "Enter the 4 digit code\n sent to your email",
                color = colorResource(id = R.color.content_neutral_primary_black),
                style = TextStyleInter16Lh24Fw700(),
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                modifier = Modifier.padding(top = 10.sdp)
            )
        }
        Column(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxSize()
                .padding(start = 22.sdp, end = 22.sdp),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly

        )
        {

            val focusManager = LocalFocusManager.current
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.sdp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                ) {
                    OutlinedTextField(
                        value = otp1,
                        onValueChange = {
                            if(it.length<=1)otp1 = it
                            if (it.isNotEmpty()) {
                                focusManager.moveFocus(FocusDirection.Next)
                            }
                            if(it.isEmpty()){
                                focusManager.clearFocus()
                            }
                        },
                        shape = RoundedCornerShape(10.sdp),
                        modifier = Modifier
                            .padding( top = 10.sdp)
                            .width(50.sdp),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Next) }
                        ),
                        maxLines = 1,
                        isError = uiStates.isOtpValid == false,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = colorResource(id = R.color.bg_neutral_light_default),
                            unfocusedContainerColor = colorResource(id = R.color.bg_neutral_light_default),
                            focusedBorderColor = if (uiStates?.isOtpValid != false) colorResource(id = R.color.primary_color) else colorResource(
                                id = R.color.stroke_danger_normal
                            ),
                            unfocusedBorderColor = Color.Transparent,
                            cursorColor = if (uiStates?.isOtpValid != false) colorResource(id = R.color.primary_color) else colorResource(
                                id = R.color.stroke_danger_normal
                            ),
                            focusedLabelColor = if (uiStates?.isOtpValid != false) colorResource(id = R.color.primary_color) else colorResource(
                                id = R.color.stroke_danger_normal
                            ),
                            unfocusedLabelColor = colorResource(id = R.color.content_neutral_primary_black),
                            focusedTextColor = colorResource(id = R.color.content_neutral_primary_black),
                            unfocusedTextColor = colorResource(id = R.color.content_neutral_primary_black),
                            focusedPlaceholderColor = if (uiStates?.isOtpValid != false) colorResource(
                                id = R.color.primary_color
                            ) else colorResource(
                                id = R.color.stroke_danger_normal
                            ),
                            unfocusedPlaceholderColor = colorResource(id = R.color.content_neutral_primary_black),
                            errorBorderColor = colorResource(id = R.color.stroke_danger_normal),
                            errorContainerColor = colorResource(id = R.color.bg_neutral_light_default),
                            errorLabelColor = colorResource(id = R.color.stroke_danger_normal),
                        ),

                        )
                    OutlinedTextField(
                        value = otp2,
                        onValueChange = {
                            if(it.length<=1)otp2 = it
                            if (it.isNotEmpty()) {
                                focusManager.moveFocus(FocusDirection.Next)
                            }
                            if(it.isEmpty())focusManager.moveFocus(FocusDirection.Previous)
                        },
                        shape = RoundedCornerShape(10.sdp),
                        modifier = Modifier
                            .padding( top = 10.sdp)
                            .width(50.sdp),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Number),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Next) }
                        ),
                        maxLines = 1,
                        isError = uiStates?.isOtpValid == false,
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
                    OutlinedTextField(
                        value = otp3,
                        onValueChange = {
                            if(it.length<=1)otp3 = it
                            if (it.isNotEmpty()) {
                                focusManager.moveFocus(FocusDirection.Next)
                            }
                            if(it.isEmpty()) {
                                focusManager.moveFocus(FocusDirection.Previous)
                            }
                        },
                        shape = RoundedCornerShape(10.sdp),
                        modifier = Modifier
                            .padding( top = 10.sdp)
                            .width(50.sdp),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Number),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Next) }
                        ),
                        maxLines = 1,
                        isError = uiStates?.isOtpValid == false,
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
                    OutlinedTextField(
                        value = otp4,
                        onValueChange = { if (it.length <= 1) {
                            otp4 = it
                            if (it.isNotEmpty()) {
                                focusManager.clearFocus()
                            }
                            if(it.isEmpty()) {
                                focusManager.moveFocus(FocusDirection.Previous)
                            }
                        } },
                        shape = RoundedCornerShape(10.sdp),
                        modifier = Modifier
                            .padding( top = 10.sdp)
                            .width(50.sdp),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Number),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.clearFocus() }
                        ),
                        maxLines = 1,
                        isError = uiStates?.isOtpValid == false,
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
                }
                if (uiStates?.isOtpValid == false)
                    Text(
                        text = uiStates.errorOtpMessage,
                        color = colorResource(id = R.color.stroke_danger_normal),
                        style = TextStyleInter12Lh16Fw400(),
                        modifier = Modifier
                            .padding(start = 24.sdp, end = 24.sdp, top = 8.sdp)
                            .align(Alignment.Start),
                    )
            }
        }
//        Row(
//            modifier = Modifier
//                .widthIn(400.sdp)
//                .padding(end = 24.sdp),
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
//        ) {
//            Text(
//                text = "",
//                color = colorResource(id = R.color.primary_color),
//                style = TextStyleInter16Lh24Fw600(),
//                modifier = Modifier
//                    .padding(top = 10.sdp)
//                    .clickable { onForgotPasswordClick() }
//            )
//        }

        Button(
            onClick = { onOtpClick(otp1+otp2+otp3+otp4) },
            modifier = Modifier
                .padding(start = 48.sdp, end = 48.sdp, top = 10.sdp)
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
                style = TextStyleInter16Lh24Fw600()
            )
        }
        Text(
            text="An OTP has been sent to your email address",
            color = colorResource(id = R.color.content_neutral_primary_black),
            style = TextStyleInter12Lh16Fw500(),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 30.sdp)

        )


        Box(
            modifier = Modifier.weight(0.1f)
                .fillMaxSize()
        )
    }
}
@CompletePreviews
@Composable
fun PreviewOtpScreenPortrait() {
    OtpScreenPortrait(
        uiStates = OtpStates(),
        onOtpChange = {},
        onOtpClick = {},
        onResendOtpClick = {}
    )
}