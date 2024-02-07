package com.example.chatappclientl.model

data class UserHandle(
    val userID: Int,
    val firstName: String,
    val lastName: String,
    val conversation: Int
)

data class LogInUser(
    val userID: Int,
    val firstName: String,
    val lastName: String,
    val email: String
)

data class UserNotFriend(
    val userID: Int,
    val firstName: String,
    val lastName: String
)