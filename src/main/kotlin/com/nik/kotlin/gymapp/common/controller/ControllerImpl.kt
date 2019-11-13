package com.nik.kotlin.gymapp.common.controller

import com.nik.kotlin.gymapp.common.entity.Entity
import com.nik.kotlin.gymapp.common.service.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.hateoas.Link
import org.springframework.hateoas.config.EnableHypermediaSupport
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@EnableHypermediaSupport(type = [HypermediaType.HAL])
abstract class ControllerImpl<T : Entity>
(@Autowired private val service: Service<T>) : Controller<T>{

    @PostMapping
    override fun addNew(@RequestBody(required = true) @Valid entity: T) : ResponseEntity<T> {

        return ResponseEntity.ok(service.addNew(entity))
    }

    @GetMapping(path = ["/{ID}"])
    override fun getById(@PathVariable ID: String) : ResponseEntity<T> {
        return ResponseEntity.ok(service.getById(ID))
    }

    @GetMapping
    override fun getAll(@RequestParam(required = false, defaultValue = "10") size : Int,
                        @RequestParam(required = false, defaultValue = "0") page : Int,
                        @RequestParam(required = false, defaultValue = "ID") sort : String): ResponseEntity<Page<T>> {

        val sort = Sort.by(sort)

        return ResponseEntity.ok(service.getAll(size, page, sort))
    }

    @PatchMapping(path = ["/{ID}"])
    override fun update(@RequestBody(required = true) @Valid entity: T,
                        @PathVariable ID: String) : ResponseEntity<T> {
        return ResponseEntity.ok(service.update(entity, ID))
    }

    @DeleteMapping
    override fun delete(ID: String) : ResponseEntity<Boolean> {
        return ResponseEntity.ok(service.delete(ID));
    }
}