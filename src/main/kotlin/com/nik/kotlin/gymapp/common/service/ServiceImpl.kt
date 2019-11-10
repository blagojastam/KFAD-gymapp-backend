package com.nik.kotlin.gymapp.common.service

import com.nik.kotlin.gymapp.common.entity.Entity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository

@org.springframework.stereotype.Service
abstract class ServiceImpl<T : Entity>
@Autowired constructor(private val repository: JpaRepository<T, Long>): Service<T>
{
    override fun addNew(entity: T): T {
        return repository.save(entity)
    }

    override fun getById(ID: Long): T {
        return repository.findById(ID).get()
    }

    override fun getAll(): Collection<T> {
        return repository.findAll().toList()
    }

    override fun update(entity: T, ID: Long) : T {
        val retrieved : T = getById(ID)
        val id : Long? = retrieved.ID

        entity.ID = id
        return repository.save(entity);
    }

    override fun delete(ID: Long) : Boolean {
        repository.delete(repository.findById(ID).get())
        return true;
    }
}