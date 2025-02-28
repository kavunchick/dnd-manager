package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

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
) : BaseEntity() {

    companion object : PanacheCompanion<Equipment>

}