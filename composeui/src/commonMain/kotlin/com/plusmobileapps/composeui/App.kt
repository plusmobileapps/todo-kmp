package com.plusmobileapps.composeui
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.plusmobileapps.sharedcode.platform

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, ${platform()}"
        }) {
            Text(text)
        }
    }
}
