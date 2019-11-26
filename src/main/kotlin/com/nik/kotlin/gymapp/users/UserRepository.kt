package com.nik.kotlin.gymapp.users

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, String> {
    fun findByUsername(username: String) : User?
    fun findByEmail(email: String) : User?
}