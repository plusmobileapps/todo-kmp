package com.plusmobileapps.sharedcode

import com.plusmobileapps.sharedcode.db.TodoQueries
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

typealias DbTodo = com.plusmobileapps.sharedcode.db.Todo

interface TodoRepository {
    fun getTodos(): Flow<List<Todo>>
    fun insert(text: String)
    fun updateChecked(id: Long, isChecked: Boolean)
    fun updateText(id: Long, text: String)
    fun delete(id: Long)
    fun deleteAll()
    fun deleteChecked()
}

internal class TodoRepositoryImpl(private val database: TodoQueries, private val ioContext: CoroutineContext) : TodoRepository {
    private val job = Job()
    private val scope = CoroutineScope(job + ioContext)

    override fun getTodos(): Flow<List<Todo>> {
        return database.selectAll()
            .asFlow()
            .mapToList()
            .map { items ->
                items.map { it.mapToTodo() }
            }
    }

    override fun insert(text: String) {
        if (text.isEmpty()) return
        scope.launch {
            database.insertItem(text)
        }
    }

    override fun updateChecked(id: Long, isChecked: Boolean) {
        scope.launch {
            database.toggleChecked(id = id, is_checked = isChecked)
        }
    }

    override fun updateText(id: Long, text: String) {
        scope.launch {
            database.updateText(id = id, text = text)
        }
    }

    override fun delete(id: Long) {
        scope.launch {
            database.deleteItem(id)
        }
    }

    override fun deleteAll() {
        scope.launch {
            database.deleteAll()
        }
    }

    override fun deleteChecked() {
        scope.launch {
            database.deleteChecked()
        }
    }

    private fun DbTodo.mapToTodo(): Todo {
        return Todo(
            id = id,
            text = text,
            isChecked = is_checked
        )
    }
}