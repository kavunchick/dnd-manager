package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity
import jakarta.persistence.Column

@Entity
data class Alignment(

    @Column(nullable = false)
    var name: String,
) : PanacheEntity() {

    companion object : PanacheCompanion<Alignment>

}