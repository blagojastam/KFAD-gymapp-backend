package com.nik.kotlin.gymapp.common.controller

import org.springframework.hateoas.RepresentationModel

open class RepresentationModel<T>(entity: T) : RepresentationModel<com.nik.kotlin.gymapp.common.controller.RepresentationModel<T>>() {


}