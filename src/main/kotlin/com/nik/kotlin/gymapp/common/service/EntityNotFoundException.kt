package com.nik.kotlin.gymapp.common.service

class EntityNotFoundException(
        override val message: String?
) : RuntimeException(message) {
}