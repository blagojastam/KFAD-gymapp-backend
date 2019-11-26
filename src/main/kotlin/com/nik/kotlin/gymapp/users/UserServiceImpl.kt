package com.nik.kotlin.gymapp.users

import com.nik.kotlin.gymapp.common.service.ServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("userService")
class UserServiceImpl
constructor(@Autowired override val repository: UserRepository) : ServiceImpl<User>(repository) {

    fun findByUsername(username: String) : User? {
        return repository.findByUsername(username)
    }

    fun findByEmail(email: String) : User? {
        return repository.findByEmail(email)
    }
}