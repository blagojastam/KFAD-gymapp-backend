package com.nik.kotlin.gymapp.common.service

import org.springframework.stereotype.Service

@Service
interface Service<T> {
    fun addNew(entity : T) : T
    fun getById(ID : Long) : T
    fun getAll() : Collection<T>
    fun update(entity: T, ID: Long) : T
    fun delete(ID : Long) : Boolean
}