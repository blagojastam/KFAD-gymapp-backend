package com.nik.kotlin.gymapp.common.entity

import org.springframework.hateoas.EntityModel
import java.util.*
import javax.persistence.*
import javax.persistence.Entity

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class DomainEntity (
        @Id
        var ID: String = UUID.randomUUID().toString())