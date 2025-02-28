package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "creature_types")
data class CreatureType(

    @Column(nullable = false)
    var name: String
) : BaseEntity() {

    companion object : PanacheCompanion<CreatureType>

}