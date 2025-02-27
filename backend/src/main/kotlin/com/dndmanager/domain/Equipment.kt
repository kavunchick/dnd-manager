package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.*

@Entity
@Table(name = "equipment")
data class Equipment(

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var description: String,

    @Column(nullable = false)
    var suggestedPriceGp: Short,

    @Column(nullable = false)
    var weight: Double
) : PanacheEntity() {

    companion object : PanacheCompanion<Equipment>

}