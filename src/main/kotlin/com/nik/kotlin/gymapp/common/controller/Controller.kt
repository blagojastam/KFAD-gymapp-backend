package com.nik.kotlin.gymapp.common.controller

import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
interface Controller<T> {
    fun addNew(entity : T) : ResponseEntity<T>
    fun getById(ID : String) : ResponseEntity<RepresentationModel<T>>
    fun getAll(size : Int, page: Int, sort: String) : ResponseEntity<Page<T>>
    fun update(entity: T, ID: String) : ResponseEntity<T>
    fun delete(ID : String) : ResponseEntity<Boolean>
}