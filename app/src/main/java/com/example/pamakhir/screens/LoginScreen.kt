package com.example.pamakhir.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pamakhir.LoginViewModel
import com.example.pamakhir.R
import com.example.pamakhir.components.*
import com.example.pamakhir.data.LoginUIEvent
import com.example.pamakhir.navigation.PostOfficeAppRouter
import com.example.pamakhir.navigation.Screen
import com.example.pamakhir.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel()) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
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

                EmailFieldContent(
                    labelValue = stringResource(id = R.string.email),
                    painter = painterResource(id = R.drawable.email),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )

                Spacer(modifier = Modifier.height(5.dp))

                PasswordFieldContent(
                    labelValue = stringResource(id = R.string.password),
                    painter = painterResource(id = R.drawable.gembok),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(40.dp))


                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.login),
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(18.dp))
                DividerTextComponent()
                Spacer(modifier = Modifier.height(40.dp))

                ClickableTextRegisterContent(
                    tryingToRegister = true,
                    onTextSelected = {
                        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
                    }
                )
            }
        }
        if(loginViewModel.loginInProgress.value) {
                CircularProgressIndicator()
            }

    }
        SystemBackButtonHandler {
            PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
        }
    }

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}