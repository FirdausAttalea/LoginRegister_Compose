package com.example.pamakhir.data.rules

import android.util.Log

object Validator {


    fun validateFirstName(firstName: String): ValidationResult {
        return ValidationResult(
            (!firstName.isNullOrEmpty() && firstName.length  > 2)
        )

    }

    fun validateLastName(lastName: String): ValidationResult {
        return ValidationResult(
            (!lastName.isNullOrEmpty() && lastName.length > 2)
        )
    }

    fun validateEmail(email: String): ValidationResult {
        return ValidationResult(
            (!email.isNullOrEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        )
    }

    fun validatePassword(password: String): ValidationResult {
        return ValidationResult(
            (!password.isNullOrEmpty() && password.length > 5)
        )
    }

    fun validatePrivacyPolicyAcceptance(statusValue:Boolean):ValidationResult{
        return ValidationResult(
            statusValue
        )
    }

}

data class ValidationResult(
    val status: Boolean = false
)







