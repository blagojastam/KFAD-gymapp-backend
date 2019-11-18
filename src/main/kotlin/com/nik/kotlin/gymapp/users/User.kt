package com.nik.kotlin.gymapp.users

import com.fasterxml.jackson.annotation.JsonRootName
import javax.persistence.Entity

@Entity
data class User (
        var firstName: String? = null,
        var lastName: String? = null,
        var email: String? = null) : com.nik.kotlin.gymapp.common.entity.Entity()