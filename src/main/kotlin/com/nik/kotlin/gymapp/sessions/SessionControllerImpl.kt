package com.nik.kotlin.gymapp.sessions

import com.nik.kotlin.gymapp.common.service.EntityNotFoundException
import com.nik.kotlin.gymapp.users.User
import com.nik.kotlin.gymapp.users.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class SessionControllerImpl(
        @Autowired val sessionService: SessionServiceImpl,
        @Autowired val userService: UserServiceImpl,
        @Autowired val passwordEncoder: PasswordEncoder)  {

    @PostMapping("/login")
    fun login(username:String, password:String) : ResponseEntity<String> {
        val user = userService.findByUsername(username)
                ?: userService.findByEmail(username)
                ?: return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A user matching those details could not be found.")

        if (!passwordEncoder.matches(password, user.password)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A user matching those details could not be found.")

        } else {
            val newSession = Session(true, user);
            sessionService.addNew(newSession)
            return ResponseEntity.accepted().header("SESSION_ID", newSession.ID).build()
        }
    }

    @PostMapping("/logout")
    fun logout(@RequestHeader SESSION_ID: String) : ResponseEntity<String>{
        try {
            val session = sessionService.findById(SESSION_ID);
            session.deactivate()
            sessionService.update(session, SESSION_ID);
            return ResponseEntity.ok("")

        } catch (exception:EntityNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Session could not be found.")
        }
    }

    @PostMapping("/register")
    fun register(username: String, password: String, email: String) : ResponseEntity<String>{
        if (userService.findByUsername(username) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already in use.")

        } else if (userService.findByEmail(email) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email address already in use.")
        }

        val newUser = User(email, passwordEncoder.encode(password), username)
        userService.addNew(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
}