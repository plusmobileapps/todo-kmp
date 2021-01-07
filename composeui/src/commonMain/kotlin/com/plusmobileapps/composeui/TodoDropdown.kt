package com.plusmobileapps.composeui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*


@Composable
fun TodoDropdownMenu(
    onClearAllClicked: () -> Unit,
    onClearCheckedClicked: () -> Unit
) {
    val items = listOf("Clear all items", "Clear checked items")
    var showMenu by remember { mutableStateOf(false) }

    DropdownMenu(
        toggle = {
            IconButton(onClick = { showMenu = true }) {
                Icon(Icons.Default.MoreVert)
            }
        },
        expanded = showMenu,
        onDismissRequest = { showMenu = false },
    ) {
        DropdownMenuItem(
            onClick = {
                onClearAllClicked()
                showMenu = false
            }
        ) {
            Text("Clear all items")
        }
        DropdownMenuItem(
            onClick = {
                onClearCheckedClicked()
                showMenu = false
            }
        ) {
            Text("Clear checked items")
        }
    }
}