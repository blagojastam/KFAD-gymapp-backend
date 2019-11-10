package com.nik.kotlin.gymapp.users

import com.nik.kotlin.gymapp.common.controller.ControllerImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserControllerImpl
@Autowired constructor(serviceImpl: UserServiceImpl) : ControllerImpl<User>(serviceImpl) {

}