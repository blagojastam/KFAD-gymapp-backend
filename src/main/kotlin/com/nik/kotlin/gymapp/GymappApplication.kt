package com.nik.kotlin.gymapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@EntityScan(basePackages = ["com.nik.kotlin.gymapp.*"])
@SpringBootApplication(exclude = [SecurityAutoConfiguration::class]) // TODO: enable security
class GymappApplication

fun main(args: Array<String>) {
	runApplication<GymappApplication>(*args)
}
