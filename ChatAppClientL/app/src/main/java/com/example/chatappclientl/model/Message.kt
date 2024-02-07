package com.example.chatappclientl.model

data class Message(
    val firstName: String,
    val senderID: Int,
    val receiverID: Int,
    val content: String
)

data class UnreadMessage(
    val sender: String,
    val content: String
)