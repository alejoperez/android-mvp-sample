package com.mvp.sample.webservice

import com.mvp.sample.data.User


class RegisterResponse(val id: String,
                       val name: String,
                       val email: String,
                       val accessToken: String) {

    fun toUser(): User = User(id,name,email)
}

class LoginResponse(val success: Boolean,
                    val id: String,
                    val name: String,
                    val email: String,
                    val accessToken: String) {

    fun toUser(): User = User(id,name,email)
}