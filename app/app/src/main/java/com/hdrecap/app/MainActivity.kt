package com.hdrecap.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecapHomeScreen()
                }
            }
        }
    }
}

@Composable
fun RecapHomeScreen() {
    var videoUrl by remember { mutableStateOf("") }
    var statusText by remember { mutableStateOf("Ready to process video") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "HD Recap AI",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = videoUrl,
            onValueChange = { videoUrl = it },
            label = { Text("Paste Video Link") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                statusText = if (videoUrl.isBlank()) {
                    "Please enter a valid link"
                } else {
                    "Processing: $videoUrl"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Start Recap & Dubbing")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = statusText)
    }
}
