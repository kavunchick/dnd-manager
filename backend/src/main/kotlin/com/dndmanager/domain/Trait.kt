package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "traits")
data class Trait (

    @Column(nullable = false)
    var name: String,

    @Column(columnDefinition = "TEXT")
    var description: String?,
) : BaseEntity() {

    companion object : PanacheCompanion<Trait>

}