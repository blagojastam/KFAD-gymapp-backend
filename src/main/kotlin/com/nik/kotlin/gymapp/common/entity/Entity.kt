package com.nik.kotlin.gymapp.common.entity

import java.util.*
import javax.persistence.*
import javax.persistence.Entity

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Entity (
        @Id
        var ID: String = UUID.randomUUID().toString())