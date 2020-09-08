package com.anushka.viewmodelscopedemo.model

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User> {
        delay(8000)
        val users: List<User> = listOf(
            User(id = 1, name = "Tom"),
            User(id = 1, name = "Jerry"),
            User(id = 1, name = "Rick"),
            User(id = 1, name = "Morty"),
            User(id = 1, name = "Beth")
        )

        return users
    }
}