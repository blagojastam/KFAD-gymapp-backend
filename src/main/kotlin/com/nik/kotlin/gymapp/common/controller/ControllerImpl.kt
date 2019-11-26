package com.nik.kotlin.gymapp.common.controller

import com.nik.kotlin.gymapp.common.entity.DomainEntity
import com.nik.kotlin.gymapp.common.service.EntityNotFoundException
import com.nik.kotlin.gymapp.common.service.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.hateoas.config.EnableHypermediaSupport
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@EnableHypermediaSupport(type = [HypermediaType.HAL])
abstract class ControllerImpl<T : DomainEntity>
(@Autowired protected val service: Service<T>,
 @Autowired protected val representationModelAssembler: RepresentationModelAssembler<T>) : Controller<T>{

    @Secured("ADMIN")
    @PostMapping
    override fun addNew(@RequestBody(required = true) @Valid entity: T) : ResponseEntity<T> {
        return ResponseEntity.ok(service.addNew(entity))
    }

    @GetMapping("/{ID}")
    override fun getById(@PathVariable ID: String) : ResponseEntity<RepresentationModel<T>> {
        val entity : T

        try {
            entity = service.findById(ID)
        } catch (exception: EntityNotFoundException) {
            return ResponseEntity.notFound().build()
        }

        return ResponseEntity.ok(representationModelAssembler.toModel(entity))
    }

    @GetMapping
    override fun getAll(@RequestParam(required = false, defaultValue = "10") size : Int,
                        @RequestParam(required = false, defaultValue = "0") page : Int,
                        @RequestParam(required = false, defaultValue = "ID") sort : String): ResponseEntity<Page<T>> {

        val sort = Sort.by(sort)

        return ResponseEntity.ok(service.findAll(size, page, sort))
    }

    @PatchMapping("/{ID}")
    override fun update(@RequestBody(required = true) @Valid entity: T,
                        @PathVariable ID: String) : ResponseEntity<T> {

        return ResponseEntity.ok(service.update(entity, ID))
    }

    @DeleteMapping("/{ID}")
    override fun delete(@PathVariable ID: String) : ResponseEntity<Boolean> {
        return ResponseEntity.ok(service.delete(ID));
    }
}