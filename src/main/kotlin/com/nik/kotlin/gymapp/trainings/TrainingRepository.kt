package com.nik.kotlin.gymapp.trainings

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrainingRepository : JpaRepository<Training, String>