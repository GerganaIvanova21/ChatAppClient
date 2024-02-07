package com.example.chatappclientl.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatappclientl.service.AuthService
import kotlinx.coroutines.launch

// Authentication module

class SignUpViewModel(private val authService: AuthService) : ViewModel() {

    private val _signUpStatus = mutableStateOf<SignUpStatus?>(null)
    val signUpStatus: Thread.State<SignUpStatus?> = _signUpStatus

    // Function to perform sign-up
    fun signUp(firstName: String, lastName: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                // Perform sign-up through the authentication service
                authService.signUp(firstName, lastName, email, password)

                // Update sign-up status if successful
                _signUpStatus.value = SignUpStatus.Success
            } catch (e: Exception) {
                // Handle sign-up failure and update status
                _signUpStatus.value = SignUpStatus.Error(e.localizedMessage ?: "Sign-up failed")
            }
        }
    }
}

// Define a sealed class for sign-up status
sealed class SignUpStatus {
    object Success : SignUpStatus()
    data class Error(val message: String) : SignUpStatus()
}
