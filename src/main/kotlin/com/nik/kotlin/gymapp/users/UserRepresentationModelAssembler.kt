package com.nik.kotlin.gymapp.users

import com.nik.kotlin.gymapp.common.controller.RepresentationModel
import com.nik.kotlin.gymapp.common.controller.RepresentationModelAssembler
import org.springframework.hateoas.Link
import org.springframework.hateoas.LinkRelation
import org.springframework.hateoas.server.LinkBuilder
import org.springframework.hateoas.server.LinkBuilderFactory
import org.springframework.hateoas.server.core.LinkBuilderSupport
import org.springframework.hateoas.server.mvc.BasicLinkBuilder
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.stereotype.Component
import kotlin.reflect.jvm.javaMethod

@Component
class UserRepresentationModelAssembler : RepresentationModelAssembler<User> () {
//    override fun toModel(entity: User): RepresentationModel<User> {
//
//        val representationModel = UserRepresentationModel(entity)
//
//        val link = WebMvcLinkBuilder.linkTo(UserControllerImpl::class.java).slash(entity.ID).withSelfRel()
//
//        return representationModel.add(link)
//    }
}