package com.plusmobileapps.composeui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.plusmobileapps.sharedcode.TodoRepository

@Composable
fun TodoList(repository: TodoRepository) {
    val todos = repository.getTodos().collectAsState(initial = listOf())

    if (todos.value.isEmpty()) {
        Column(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .clickable(onClick = { }) /*question = "3 Bananas required"*/
                .clip(shape = RoundedCornerShape(16.dp)),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Add items to your todo list below to see them here",
                Modifier.padding(16.dp),
                textAlign = TextAlign.Center,
            )
            return
        }
    }
    LazyColumn {
        items(todos.value) { item ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillParentMaxWidth().clickable {
                    repository.updateChecked(item.id, !item.isChecked)
                }
            ) {
                Checkbox(
                    checked = item.isChecked,
                    modifier = Modifier.padding(16.dp),
                    onCheckedChange = { repository.updateChecked(item.id, it) }
                )
                Box(Modifier.weight(1F)) {
                    Text(text = item.text)
                }
                IconButton(onClick = { repository.delete(item.id) }) {
                    Icon(Icons.Default.Delete)
                }
            }
        }
    }
}