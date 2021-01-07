package com.plusmobileapps.sharedcode

import kotlin.coroutines.CoroutineContext

expect val mainDispatcher: CoroutineContext
expect val ioDispatcher: CoroutineContext