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
import com.example.pamakhir.R
import com.example.pamakhir.components.ButtonComponent
import com.example.pamakhir.components.ClickableTextLoginContent
import com.example.pamakhir.components.DividerTextComponent
import com.example.pamakhir.components.EmailFieldContent
import com.example.pamakhir.components.HeadingTextContent
import com.example.pamakhir.components.NormalTextContent
import com.example.pamakhir.components.PasswordFieldContent
import com.example.pamakhir.components.UnderLinedTextComponent
import com.example.pamakhir.navigation.PostOfficeAppRouter
import com.example.pamakhir.navigation.Screen
import com.example.pamakhir.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen(){
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextContent(value = stringResource(id = R.string.login))
            HeadingTextContent(value = stringResource(id = R.string.welcome_back))
            Spacer(modifier = Modifier.height(80.dp))

            EmailFieldContent(
                labelValue = stringResource(id = R.string.email),
                painter = painterResource(id = R.drawable.email)
            )
            Spacer(modifier = Modifier.height(5.dp))
            PasswordFieldContent(
                labelValue = stringResource(id = R.string.password),
                painter = painterResource(id = R.drawable.gembok)
            )
            UnderLinedTextComponent(value = stringResource(id = R.string.forgot_password))

            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.login))
            Spacer(modifier = Modifier.height(18.dp))
            DividerTextComponent()
            Spacer(modifier = Modifier.height(40.dp))

            ClickableTextLoginContent(tryingToLogin = false, onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
            })
        }

    }

    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }
}


@Preview
@Composable
fun DefaultPreviewOfLoginScreen(){
    LoginScreen()
}