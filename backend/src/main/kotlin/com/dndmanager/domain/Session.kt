package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "sessions")
data class Session(

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var start: Instant,

    var lastUpdated: Instant?,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn
    var characters: List<SessionsCharacter>
) : BaseEntity() {

    companion object : PanacheCompanion<Session>

}