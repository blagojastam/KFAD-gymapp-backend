package com.nik.kotlin.gymapp.trainings

import com.nik.kotlin.gymapp.common.service.ServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TrainingServiceImpl
(@Autowired repository: TrainingRepository) : ServiceImpl<Training>(repository)