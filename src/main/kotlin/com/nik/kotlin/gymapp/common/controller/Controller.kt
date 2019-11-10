package com.nik.kotlin.gymapp.common.controller

import com.nik.kotlin.gymapp.common.entity.Entity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
interface Controller<T> {
    fun addNew(entity : T) : ResponseEntity<T>
    fun getById(ID : Long) : ResponseEntity<T>
    fun getAll() : ResponseEntity<Collection<T>>
    fun update(entity: T, ID: Long) : ResponseEntity<T>
    fun delete(ID : Long) : ResponseEntity<Boolean>
}