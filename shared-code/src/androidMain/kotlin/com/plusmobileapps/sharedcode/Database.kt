package com.plusmobileapps.sharedcode

import android.content.Context
import com.plusmobileapps.sharedcode.db.MyDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver

lateinit var context: Context

actual fun createDb(): MyDatabase {
    val driver = AndroidSqliteDriver(MyDatabase.Schema, context, "database.db")
    return MyDatabase.invoke(driver)
}