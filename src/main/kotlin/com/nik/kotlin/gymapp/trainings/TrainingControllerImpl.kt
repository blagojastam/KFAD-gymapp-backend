package com.nik.kotlin.gymapp.trainings

import com.nik.kotlin.gymapp.common.controller.ControllerImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/trainings")
class TrainingControllerImpl
(@Autowired serviceImpl: TrainingServiceImpl) : ControllerImpl<Training>(serviceImpl)