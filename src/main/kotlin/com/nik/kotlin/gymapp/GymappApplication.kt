package com.nik.kotlin.gymapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GymappApplication

fun main(args: Array<String>) {
	runApplication<GymappApplication>(*args)
}
