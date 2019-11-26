package com.nik.kotlin.gymapp.users

import org.springframework.stereotype.Component
import java.util.*

@Component
interface UserAuthenticationService {
    fun logout(user:User)
    fun findByToken(token:String) : Optional<User>
    fun login(username:String, password:String) : Optional<User>
}