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
import com.example.pamakhir.data.SignUpViewModel
import com.example.pamakhir.data.SignUpUIEvent
import com.example.pamakhir.navigation.PostOfficeAppRouter
import com.example.pamakhir.navigation.Screen


@Composable
fun SignUpScreen(signUpViewModel : SignUpViewModel = viewModel()){4

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
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
                        signUpViewModel.onEvent(SignUpUIEvent.FirstNameChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.firstNameError
                )
                Spacer(modifier = Modifier.height(5.dp))
                MyTextFieldContent(
                    labelValue = stringResource(id = R.string.last_name),
                    painter = painterResource(id = R.drawable.person),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUIEvent.LastNameChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.lastNameError

                )
                Spacer(modifier = Modifier.height(5.dp))
                EmailFieldContent(
                    labelValue = stringResource(id = R.string.email),
                    painter = painterResource(id = R.drawable.email),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUIEvent.EmailChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.emailError

                )
                Spacer(modifier = Modifier.height(5.dp))
                PasswordFieldContent(
                    labelValue = stringResource(id = R.string.password),
                    painter = painterResource(id = R.drawable.gembok),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUIEvent.PasswordChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.passwordError

                )
                CheckboxContent(value = stringResource(id = R.string.terms_condition),
                    onTextSelected = {
                        PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                    },
                    onCheckedChange = {
                        signUpViewModel.onEvent(SignUpUIEvent.PrivacyPolicyCheckBoxClicked(it))
                    }
                )
                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(value = stringResource(id = R.string.register),
                    onButtonClicked = {
                        signUpViewModel.onEvent(SignUpUIEvent.RegisterButtonClicked)
                    },
                    isEnabled = signUpViewModel.allValidationsPassed.value
                )
                Spacer(modifier = Modifier.height(18.dp))
                DividerTextComponent()
                Spacer(modifier = Modifier.height(40.dp))

                ClickableTextLoginContent(tryingToLogin = true, onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
                })
            }

        }
        if (signUpViewModel.signUpInProgress.value){
            CircularProgressIndicator()
        }
     }

}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}