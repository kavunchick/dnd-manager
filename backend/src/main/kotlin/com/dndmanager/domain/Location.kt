package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
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
) : BaseEntity() {

    companion object : PanacheCompanion<Location>

}