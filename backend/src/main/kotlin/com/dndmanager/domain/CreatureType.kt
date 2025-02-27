package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Column

@Entity
@Table(name = "creature_types")
data class CreatureType(

    @Column(nullable = false)
    var name: String
) : PanacheEntity() {

    companion object : PanacheCompanion<CreatureType>

}