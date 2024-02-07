package com.example.chatappclientl.service

// Authentication module

interface AuthService {
    suspend fun signUp(firstName: String, lastName: String, email: String, password: String): User
    suspend fun signIn(email: String, password: String): User
    suspend fun signOut()
    suspend fun getCurrentUser(): User?
}

// Example User data class
data class User(
    val userId: String,
    val firstName: String,
    val lastName: String,
    val email: String
)
