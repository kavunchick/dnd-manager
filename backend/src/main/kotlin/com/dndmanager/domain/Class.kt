package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Column

@Entity
@Table(name = "classes")
data class Class(
    @Column(nullable = false)
    var name: String,

    var description: String?,

    @Column(nullable = false)
    var hitPointDie: Short
) : PanacheEntity() {

    companion object : PanacheCompanion<Class>

}