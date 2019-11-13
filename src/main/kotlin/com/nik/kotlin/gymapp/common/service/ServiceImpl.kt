package com.nik.kotlin.gymapp.common.service

import com.nik.kotlin.gymapp.common.entity.Entity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository

@org.springframework.stereotype.Service
abstract class ServiceImpl<T : Entity>
(@Autowired private val repository: JpaRepository<T, String>): Service<T> {

    override fun addNew(entity: T): T {
        return repository.save(entity)
    }

    override fun getById(ID: String): T {
        return repository.findById(ID).get()
    }

    override fun getAll(size : Int, page: Int, sort: Sort): Page<T> {
        return repository.findAll(PageRequest.of(page, size, sort))
    }

    override fun update(entity: T, ID: String) : T {
        val retrieved : T = getById(ID)
        val id : String = retrieved.ID

        entity.ID = id
        return repository.save(entity);
    }

    override fun delete(ID: String) : Boolean {
        repository.delete(repository.findById(ID).get())
        return true;
    }
}