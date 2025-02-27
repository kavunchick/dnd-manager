package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Column

@Entity
@Table(name = "abilities")
data class Ability(

    @Column(nullable = false)
    var name: String,

    var description: String?,
) : PanacheEntity() {

    companion object : PanacheCompanion<Ability>

}