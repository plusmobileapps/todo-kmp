package com.plusmobileapps.composeui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.plusmobileapps.sharedcode.TodoRepository

@Composable
fun App(repository: TodoRepository) {
    var textField by remember { mutableStateOf("") }
    MaterialTheme {
        Column {
            TopAppBar(title = { Text("Todo") }, actions = {
                TodoDropdownMenu(
                    onClearAllClicked = { repository.deleteAll() },
                    onClearCheckedClicked = { repository.deleteChecked() }
                )
            })

            Box(modifier = Modifier.weight(1F)) {
                TodoList(repository)
            }

            TodoInput(
                text = textField,
                onTextChanged = {
                    textField = it.replace("[\n\r]".toRegex(), "")
                },
                onAddClicked = {
                    repository.insert(textField)
                    textField = ""
                }
            )
        }
    }
}
