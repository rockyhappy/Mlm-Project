package com.devrachit.mlm.presentation.auth.signupScreen

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import com.devrachit.mlm.presentation.auth.loginScreen.LoginStates
import com.devrachit.mlm.utility.composeUtility.CompletePreviews
import com.devrachit.mlm.utility.composeUtility.OrientationPreviews
import com.devrachit.mlm.utility.composeUtility.sdp
import com.devrachit.mlm.utility.composeUtility.ssp
import com.devrachit.mlm.utility.theme.TextStyleInter12Lh16Fw400
import com.devrachit.mlm.utility.theme.TextStyleInter14Lh16Fw400
import com.devrachit.mlm.utility.theme.TextStyleInter16Lh24Fw600
import com.devrachit.mlm.utility.theme.TextStyleInter16Lh24Fw700
import com.devrachit.mlm.utility.theme.TextStyleInter18Lh24Fw700

@Composable
fun SignupScreenLandscape(
    uiStates: SignupStates? = SignupStates(),
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    onLoginWithGoogleClick: () -> Unit = {},
    setEmail: (String) -> Unit = {},
    setMobile: (String) -> Unit = {},
    setName: (String) -> Unit = {},
    setPassword: (String) -> Unit = {},
    setConfirmPassword: (String) -> Unit = {}
)
{
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isConfirmPasswordVisible by remember { mutableStateOf(false) }
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
                text = "Signup Here",
                color = colorResource(id = R.color.primary_color),
                fontSize = 24.ssp,
                fontFamily = TextStyleInter18Lh24Fw700().fontFamily,
                fontWeight = TextStyleInter18Lh24Fw700().fontWeight,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                lineHeight = 28.ssp,
                textAlign = TextAlign.Center,
                modifier = Modifier

            )
            Text(
                text = "Create an account \nto get started",
                color = colorResource(id = R.color.content_neutral_primary_black),
                style = TextStyleInter16Lh24Fw700(),
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 4,
                modifier = Modifier.padding(top = 10.sdp)
            )
        }
        Column(
            modifier= Modifier.weight(0.9f).fillMaxSize().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        )
        {
            val focusManager = LocalFocusManager.current
            Column {

                OutlinedTextField(
                    value = uiStates?.name ?: "",
                    onValueChange = { setName(it) },
                    shape = RoundedCornerShape(10.sdp),
                    modifier = Modifier
                        .padding(start = 24.sdp, end = 24.sdp, top = 30.sdp)
                        .widthIn(400.sdp),
                    label = {
                        Text(
                            text = "Name",
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
                    isError = uiStates?.isNameValid == false,
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
                if (uiStates?.isNameValid == false)
                    Text(
                        text = uiStates.errorNameMessage,
                        color = colorResource(id = R.color.stroke_danger_normal),
                        style = TextStyleInter12Lh16Fw400(),
                        modifier = Modifier
                            .padding(start = 24.sdp, end = 24.sdp, top=8.sdp)
                            .align(Alignment.Start),
                    )
            }
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
            Column {

                OutlinedTextField(
                    value = uiStates?.mobile?: "",
                    onValueChange = { setMobile(it) },
                    shape = RoundedCornerShape(10.sdp),
                    modifier = Modifier
                        .padding(start = 24.sdp, end = 24.sdp, top = 10.sdp)
                        .widthIn(400.sdp),
                    label = {
                        Text(
                            text = "Mobile",
                            style = TextStyleInter14Lh16Fw400(),
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.sdp))
                                .background(Color.Transparent)
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone,imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    maxLines = 1,
                    isError = uiStates?.isMobileValid == false,
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
                if (uiStates?.isMobileValid == false)
                    Text(
                        text = uiStates.errorMobileMessage,
                        color = colorResource(id = R.color.stroke_danger_normal),
                        style = TextStyleInter12Lh16Fw400(),
                        modifier = Modifier
                            .padding(start = 24.sdp, end = 24.sdp, top=8.sdp)
                            .align(Alignment.Start),
                    )
            }
            Column {
                OutlinedTextField(
                    value = uiStates?.password ?: "",
                    onValueChange = { setPassword(it) },
                    shape = RoundedCornerShape(10.sdp),
                    modifier = Modifier
                        .padding(start = 24.sdp, end = 24.sdp, top = 10.sdp)
                        .widthIn(400.sdp),
                    label = {
                        Text(
                            text = "Password",
                            style = TextStyleInter14Lh16Fw400(),
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.sdp))
                                .background(Color.Transparent)
                        )
                    },
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (isPasswordVisible)
                            painterResource(id = R.drawable.ic_eye_closed)
                        else
                            painterResource(id = R.drawable.ic_eye_opened)

                        IconButton(
                            onClick = { isPasswordVisible = !isPasswordVisible },
                            modifier = Modifier
                                .size(24.sdp)
                        ) {
                            Icon(painter = image, contentDescription = null)
                        }
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    maxLines = 1,
                    isError = uiStates?.isPasswordValid == false,
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
                if (uiStates?.isPasswordValid == false)
                    Text(
                        text = uiStates.errorPasswordMessage,
                        color = colorResource(id = R.color.stroke_danger_normal),
                        style = TextStyleInter12Lh16Fw400(),
                        modifier = Modifier
                            .padding(start = 24.sdp, end = 24.sdp,top=8.sdp)
                            .align(Alignment.Start),
                    )
            }
            Column {
                OutlinedTextField(
                    value = uiStates?.confirmPassword ?: "",
                    onValueChange = { setConfirmPassword(it) },
                    shape = RoundedCornerShape(10.sdp),
                    modifier = Modifier
                        .padding(start = 24.sdp, end = 24.sdp, top = 10.sdp)
                        .widthIn(400.sdp),
                    label = {
                        Text(
                            text = "Confirm Password",
                            style = TextStyleInter14Lh16Fw400(),
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.sdp))
                                .background(Color.Transparent)
                        )
                    },
                    visualTransformation = if (isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (isConfirmPasswordVisible)
                            painterResource(id = R.drawable.ic_eye_closed)
                        else
                            painterResource(id = R.drawable.ic_eye_opened)

                        IconButton(
                            onClick = { isConfirmPasswordVisible = !isConfirmPasswordVisible },
                            modifier = Modifier
                                .size(24.sdp)
                        ) {
                            Icon(painter = image, contentDescription = null)
                        }
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    maxLines = 1,
                    isError = uiStates?.isConfirmPasswordValid == false,
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
                if (uiStates?.isConfirmPasswordValid == false)
                    Text(
                        text = uiStates.errorConfirmPasswordMessage,
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
                onClick = onSignUpClick,
                modifier= Modifier
                    .padding(start = 24.sdp, end = 24.sdp, top = 30.sdp)
                    .height(50.sdp)
                    .widthIn(400.sdp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.primary_color),
                    disabledContainerColor = colorResource(id = R.color.surface_card_normal_default),
                ),
                shape = RoundedCornerShape(10.sdp)
            ) {
                Text(
                    text = "SignUp",
                    color = colorResource(id = R.color.extra_blue_0),
                    style= TextStyleInter16Lh24Fw600()
                )
            }
            Text(
                text = "Already have an account",
                color = colorResource(id = R.color.content_neutral_primary_black),
                style = TextStyleInter16Lh24Fw600(),
                modifier = Modifier
                    .padding(top = 10.sdp, bottom=30.sdp)
                    .clickable { onSignUpClick() }
            )

        }

    }
}

@OrientationPreviews
@Composable
fun PreviewSignupScreenLandscape()
{
    SignupScreenLandscape()
}