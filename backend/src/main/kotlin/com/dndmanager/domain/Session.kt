package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "sessions")
data class Session (

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var start: Instant,

    var lastUpdated: Instant?
) : BaseEntity() {

    companion object : PanacheCompanion<Session>

}