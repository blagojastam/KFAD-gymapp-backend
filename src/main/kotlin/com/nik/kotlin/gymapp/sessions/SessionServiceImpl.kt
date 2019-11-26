package com.nik.kotlin.gymapp.sessions

import com.nik.kotlin.gymapp.common.service.ServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SessionServiceImpl(@Autowired override val repository: SessionRepository) : ServiceImpl<Session> (repository) {
}