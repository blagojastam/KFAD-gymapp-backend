package com.nik.kotlin.gymapp.common.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
abstract class Entity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var ID : Long? = null) {
}