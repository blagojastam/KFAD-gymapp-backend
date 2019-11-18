package com.nik.kotlin.gymapp.users

import com.nik.kotlin.gymapp.common.controller.ControllerImpl
import com.nik.kotlin.gymapp.common.controller.RepresentationModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserControllerImpl
(@Autowired serviceImpl: UserServiceImpl,
 @Autowired representationModelAssembler: UserRepresentationModelAssembler) : ControllerImpl<User>(serviceImpl, representationModelAssembler) {

    @GetMapping(path = ["/{ID}"])
    override fun getById(@PathVariable ID: String): ResponseEntity<RepresentationModel<User>> {

        val user = service.getById(ID);
        val resource = representationModelAssembler.toModel(user);

        return ResponseEntity.ok(resource)
    }
}