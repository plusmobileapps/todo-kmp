package com.plusmobileapps.sharedcode

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual val mainDispatcher: CoroutineContext = Dispatchers.Main
actual val ioDispatcher: CoroutineContext = Dispatchers.IO