package com.nik.kotlin.gymapp.trainings

import com.nik.kotlin.gymapp.users.User
import java.time.LocalDateTime
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.OneToOne

@Entity
data class Training (
        var title: String? = null,

        var description: String? = null,

        var location: String? = null,

        var startTime: LocalDateTime? = null,

        var endTime: LocalDateTime? = null,

        @OneToOne
        var trainer: User? = null,

        var participantsLimit: Int? = null,

        @ElementCollection
        var participants: List<User>? = null,

        var waitingListLimit: Int? = null,

        @ElementCollection
        var waitingList: List<User>? = null,

        var canceled: Boolean? = null

) : com.nik.kotlin.gymapp.common.entity.Entity()