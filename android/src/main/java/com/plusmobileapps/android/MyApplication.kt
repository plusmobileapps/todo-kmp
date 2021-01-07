package com.plusmobileapps.android

import android.app.Application
import com.plusmobileapps.sharedcode.context

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}