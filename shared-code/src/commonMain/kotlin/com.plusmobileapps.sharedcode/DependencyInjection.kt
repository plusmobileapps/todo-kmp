package com.plusmobileapps.sharedcode

import com.plusmobileapps.sharedcode.db.MyDatabase

object DependencyInjection {
    val database: MyDatabase = createDb()
    val todoRepository: TodoRepository = TodoRepositoryImpl(database.todoQueries, ioDispatcher)
}