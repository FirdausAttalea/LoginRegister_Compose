package com.example.pamakhir

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pamakhir.data.LoginUIEvent
import com.example.pamakhir.data.LoginUIState
import com.example.pamakhir.data.rules.Validator
import com.example.pamakhir.navigation.PostOfficeAppRouter
import com.example.pamakhir.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel(){


    private val TAG = LoginViewModel::class.simpleName

    var loginUIState = mutableStateOf(LoginUIState())

    var allValidationsPassed = mutableStateOf(false)

    var loginInProgress = mutableStateOf(false)

    fun onEvent(event: LoginUIEvent){
        when(event) {
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }
            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }
            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }
        }
        validateDataWithRules()
    }

    fun validateDataWithRules() {

        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )

        Log.d(TAG, "Inside_validateDataWithRules")
        Log.d(TAG, "emailResult = $emailResult")
        Log.d(TAG, "passwordResult = $passwordResult")

        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )
        if(emailResult.status && passwordResult.status ){
            allValidationsPassed.value = true
        } else {
            allValidationsPassed.value = false
        }
    }

    private fun login(){
        loginInProgress.value = true

        val email = loginUIState.value.email
        val password = loginUIState.value.password
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                Log.d(TAG, "Inside_login_success")
                Log.d(TAG, "isSuccessful = ${it.isSuccessful}")

                if(it.isSuccessful){
                    loginInProgress.value = false
                    PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
            }
        }
            .addOnFailureListener{
                Log.d(TAG, "Inside_login_failure")
                Log.d(TAG, "${it.localizedMessage}")

                loginInProgress.value = false

            }
    }
}