package com.nik.kotlin.gymapp.common.service

import com.nik.kotlin.gymapp.common.entity.DomainEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.repository.PagingAndSortingRepository

@org.springframework.stereotype.Service
abstract class ServiceImpl<T : DomainEntity>
(@Autowired protected val repository: PagingAndSortingRepository<T, String>): Service<T> {

    override fun addNew(entity: T): T {
        return repository.save(entity)
    }

    override fun findById(ID: String): T {
        val entity = repository.findById(ID)

        if (!entity.isPresent) {
            throw EntityNotFoundException("The requested entity could not be retrieved.")
        }

        return entity.get()
    }

    override fun findAll(size : Int, page: Int, sort: Sort): Page<T> {
        return repository.findAll(PageRequest.of(page, size, sort))
    }

    override fun update(entity: T, ID: String) : T {
        val retrieved : T = findById(ID)

        val id : String = retrieved.ID
        entity.ID = id
        return repository.save(entity);
    }

    override fun delete(ID: String) : Boolean {
        repository.delete(repository.findById(ID).get())
        return true;
    }
}