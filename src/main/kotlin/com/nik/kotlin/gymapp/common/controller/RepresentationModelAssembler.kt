package com.nik.kotlin.gymapp.common.controller

import com.nik.kotlin.gymapp.common.entity.Entity
import org.springframework.hateoas.server.RepresentationModelAssembler
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.stereotype.Component

@Component
abstract class RepresentationModelAssembler<T : Entity> : RepresentationModelAssembler<T, RepresentationModel<T>>  {
    override fun toModel(entity: T): RepresentationModel<T> {
        val representationModel = RepresentationModel(entity)

        val link = WebMvcLinkBuilder.linkTo(ControllerImpl::class.java).slash(entity.ID).withSelfRel()

        return representationModel.add(link)
    }
}