package com.anushka.coroutinesdemo1

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

// Structured concurrency
class UserDataManager2 {
    suspend fun getTotalUserCount() : Int {
        var count = 0
        lateinit var deffered : Deferred<Int>
        coroutineScope {
            launch(IO) {
                delay(1000)
                count = 50
            }

            deffered = async(IO) {
                delay(3000)
                return@async 70
            }
        }

        return count + deffered.await()
    }
}