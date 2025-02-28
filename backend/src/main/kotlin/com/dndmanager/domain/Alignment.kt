package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
data class Alignment(

    @Column(nullable = false)
    var name: String,
) : BaseEntity() {

    companion object : PanacheCompanion<Alignment>

}