package com.nik.kotlin.gymapp.common.controller

import com.nik.kotlin.gymapp.common.entity.Entity
import com.nik.kotlin.gymapp.common.service.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
abstract class ControllerImpl<T : Entity>
@Autowired constructor(private val service: Service<T>) : Controller<T>{

    @PostMapping
    override fun addNew(@RequestBody(required = true) @Valid entity: T) : ResponseEntity<T> {
        return ResponseEntity.ok(service.addNew(entity))
    }

    @GetMapping(path = ["/{ID}"])
    override fun getById(@PathVariable ID: Long) : ResponseEntity<T> {
        return ResponseEntity.ok(service.getById(ID))
    }

    @GetMapping
    override fun getAll(): ResponseEntity<Collection<T>> {
        return ResponseEntity.ok(service.getAll())
    }

    @PatchMapping(path = ["/{ID}"])
    override fun update(@RequestBody(required = true) @Valid entity: T,
                        @PathVariable ID: Long) : ResponseEntity<T> {
        return ResponseEntity.ok(service.update(entity, ID))
    }

    @DeleteMapping
    override fun delete(ID: Long) : ResponseEntity<Boolean> {
        return ResponseEntity.ok(service.delete(ID));
    }
}