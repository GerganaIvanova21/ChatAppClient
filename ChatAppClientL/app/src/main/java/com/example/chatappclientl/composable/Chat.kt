package com.example.chatappclientl.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.chatappclientl.model.Message

@Composable
fun ChatUserScreen(messages: List<Message>) {
    // Load user profile picture
    val userProfilePicture = rememberImagePainter(data = "user_profile_url")

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(messages) { message ->
            Text(text = message.text)
        }
    }

    // Compose UI components
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // User profile picture
        Image(
            painter = userProfilePicture,
            contentDescription = "User Profile Picture",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )

        // Messages between users (you can use a LazyColumn for efficiency)
        // Example: Display messages in a list
        LazyColumn {
            items(messages) { message ->
                Text(text = message.text)
            }
        }

        // Message input field
        OutlinedTextField(
            value = "Type your message...",
            onValueChange = { /* Handle input change */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Send message icon (you can add an onClick listener)
        Icon(
            imageVector = Icons.Default.Send,
            contentDescription = "Send Message",
            modifier = Modifier
                .size(48.dp)
                .padding(16.dp)
        )
    }
}
