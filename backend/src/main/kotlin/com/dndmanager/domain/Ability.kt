package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "abilities")
data class Ability(

    @Column(nullable = false)
    var name: String,

    var description: String?,
) : BaseEntity() {

    companion object : PanacheCompanion<Ability>

}