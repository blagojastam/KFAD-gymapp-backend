package com.nik.kotlin.gymapp.sessions

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository("sessionRepository")
interface SessionRepository : JpaRepository<Session, String>{
}