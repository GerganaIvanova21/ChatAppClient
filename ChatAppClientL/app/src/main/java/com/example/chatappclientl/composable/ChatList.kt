package com.example.chatappclientl.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen() {
    Column {
        TopAppBar(
            title = { Text(text = "Chat With Me") },
            /*backgroundColor = Color(0xFF6A1B9A),
            contentColor = Color.White,
            elevation = 4.dp*/
        )
        Column(modifier = Modifier.padding(8.dp)) {
            ChatBubble("gita@email.com", "good night", "12:30")
            ChatBubble("jason@email.com", "ttd", "08:11")
            ChatBubble("aldi@email.com", "oii", "07:03")
            ContactRequest("pablo@email.com")
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(/*backgroundColor = */Color(0xFF4CAF50))
        ) {
            Text(text = "Add New Message +", color = Color.White)
        }
    }
}

@Composable
fun ChatBubble(email: String, message: String, time: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = email, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = message)
        }
        Text(text = time, fontSize = 12.sp, color = Color.Gray)
    }
}

@Composable
fun ContactRequest(email: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Text(text = email)
        Row {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Decline")
            }
            Spacer(modifier = Modifier.width(8.dp))
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Accept")
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreviewOfChatList() {
    ChatScreen()
    ChatBubble(email = "", message = "", time = "")
    ContactRequest(email = "")
}