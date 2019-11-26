package com.nik.kotlin.gymapp.sessions

import com.nik.kotlin.gymapp.common.entity.DomainEntity
import com.nik.kotlin.gymapp.users.User
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Session(
        private var active: Boolean = true,
        @ManyToOne val user: User? = null) : DomainEntity (){

    fun deactivate(){
        active = false
    }
}