package com.plusmobileapps.android

import com.plusmobileapps.composeui.App
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.plusmobileapps.sharedcode.DependencyInjection
import com.plusmobileapps.sharedcode.TodoRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository: TodoRepository = DependencyInjection.todoRepository
        setContent {
            App(repository)
        }
    }
}