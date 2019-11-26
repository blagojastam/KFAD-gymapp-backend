package com.nik.kotlin.gymapp.users

import com.fasterxml.jackson.annotation.JsonIgnore
import com.nik.kotlin.gymapp.common.entity.DomainEntity
import com.nik.kotlin.gymapp.rbac.Role
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
data class User (
        var email: String? = null,
        @JsonIgnore var password: String = "",
        @JsonIgnore val username: String = "",
        @JsonIgnore @Enumerated(EnumType.STRING) var role: Role = Role.USER
): DomainEntity() {

}