package com.nik.kotlin.gymapp.users

import com.nik.kotlin.gymapp.common.service.ServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("userService")
class UserServiceImpl
constructor(@Autowired repository: UserRepository) : ServiceImpl<User>(repository) {
}