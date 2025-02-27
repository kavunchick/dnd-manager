package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.*

@Entity
@Table(name = "locations")
data class Location (

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    var session: Session,

    @Column(nullable = false)
    var name: String,

    var description: String?
) : PanacheEntity() {

    companion object : PanacheCompanion<Location>

}