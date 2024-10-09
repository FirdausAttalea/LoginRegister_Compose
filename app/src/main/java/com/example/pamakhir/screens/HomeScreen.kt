package com.example.pamakhir.screens

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pamakhir.R
import com.example.pamakhir.components.ButtonComponent
import com.example.pamakhir.components.HeadingTextContent
import com.example.pamakhir.data.SignUpViewModel

@Composable
fun HomeScreen(
    signUpViewModel: SignUpViewModel = viewModel()
) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeadingTextContent(value = stringResource(id = R.string.home))
            Spacer(modifier = Modifier.height(80.dp))

            ButtonComponent(
                value = stringResource(id = R.string.logout),
                onButtonClicked = {
                    signUpViewModel.logout()
                },
                isEnabled = true
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}