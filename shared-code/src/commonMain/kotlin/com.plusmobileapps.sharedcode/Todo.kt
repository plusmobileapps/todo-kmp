package com.plusmobileapps.sharedcode

data class Todo(
    val id: Long = -1L,
    val text: String = "",
    val isChecked: Boolean = false
)