package com.example.pamakhir.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pamakhir.R
import com.example.pamakhir.components.ButtonComponent
import com.example.pamakhir.components.CheckboxContent
import com.example.pamakhir.components.ClickableTextLoginContent
import com.example.pamakhir.components.DividerTextComponent
import com.example.pamakhir.components.EmailFieldContent
import com.example.pamakhir.components.HeadingTextContent
import com.example.pamakhir.components.MyTextFieldContent
import com.example.pamakhir.components.NormalTextContent
import com.example.pamakhir.components.PasswordFieldContent
import com.example.pamakhir.data.LoginViewModel
import com.example.pamakhir.data.UIEvent
import com.example.pamakhir.navigation.PostOfficeAppRouter
import com.example.pamakhir.navigation.Screen


@Composable
fun SignUpScreen(loginViewModel : LoginViewModel = viewModel()){
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextContent(value = stringResource(id = R.string.text_atas))
            HeadingTextContent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(80.dp))

            MyTextFieldContent(
                labelValue = stringResource(id = R.string.first_name),
                painter = painterResource(id = R.drawable.person),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.FirstNameChanged(it))
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
            MyTextFieldContent(
                labelValue = stringResource(id = R.string.last_name),
                painter = painterResource(id = R.drawable.person),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.LastNameChanged(it))
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
            EmailFieldContent(
                labelValue = stringResource(id = R.string.email),
                painter = painterResource(id = R.drawable.email),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.EmailChanged(it))
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
            PasswordFieldContent(
                labelValue = stringResource(id = R.string.password),
                painter = painterResource(id = R.drawable.gembok),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvent.PasswordChanged(it))
                }
            )
            CheckboxContent(value = stringResource(id = R.string.terms_condition),
                onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                })
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.register),
                onButtonClicked = {
                    loginViewModel.onEvent(UIEvent.RegisterButtonClicked)
                },
                isEnabled = true
                )
            Spacer(modifier = Modifier.height(18.dp))
            DividerTextComponent()
            Spacer(modifier = Modifier.height(40.dp))

            ClickableTextLoginContent(tryingToLogin = true, onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            })
        }

    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}