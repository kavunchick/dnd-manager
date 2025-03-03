package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "classes")
data class Class(
    @Column(nullable = false)
    var name: String,

    var description: String?,

    @Column(name = "hit_point_die", nullable = false)
    var hitPointDie: Short
) : BaseEntity() {

    companion object : PanacheCompanion<Class>

}