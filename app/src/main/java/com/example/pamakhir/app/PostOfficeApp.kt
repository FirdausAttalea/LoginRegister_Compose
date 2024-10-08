package com.example.pamakhir.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.pamakhir.navigation.PostOfficeAppRouter
import com.example.pamakhir.navigation.Screen
import com.example.pamakhir.screens.HomeScreen
import com.example.pamakhir.screens.LoginScreen
import com.example.pamakhir.screens.SignUpScreen
import com.example.pamakhir.screens.TermsAndConditionsScreen

@Composable
fun PostOfficeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White

    ) {
        LoginScreen()
    }
    Crossfade(targetState = PostOfficeAppRouter.currentScreen) { currentState ->
        when (currentState.value) {
            is Screen.SignUpScreen -> {
                SignUpScreen()
            }

            is Screen.TermsAndConditionsScreen -> {
                TermsAndConditionsScreen()
            }

            is Screen.LoginScreen -> {
                LoginScreen()
            }
            is Screen.HomeScreen -> {
                HomeScreen()
            }
        }

    }
}

