package com.nik.kotlin.gymapp.rbac

enum class Authority {
    CREATE_USER,
    READ_USER,
    UPDATE_USER,
    DELETE_USER,

    CREATE_TRAINING,
    READ_TRAINING,
    UPDATE_TRAINING,
    DELETE_TRAINING,
}