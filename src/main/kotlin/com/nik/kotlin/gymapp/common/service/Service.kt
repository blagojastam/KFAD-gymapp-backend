package com.nik.kotlin.gymapp.common.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
interface Service<T> {
    fun addNew(entity : T) : T
    fun getById(ID : String) : T
    fun getAll(size : Int, page: Int, sort: Sort) : Page<T>
    fun update(entity: T, ID: String) : T
    fun delete(ID : String) : Boolean
}