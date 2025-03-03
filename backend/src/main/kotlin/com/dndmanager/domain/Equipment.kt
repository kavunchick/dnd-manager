package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Lob
import jakarta.persistence.Table

@Entity
@Table(name = "equipment")
data class Equipment(

    @Column(nullable = false)
    var name: String,

    @Column(columnDefinition = "TEXT")
    var description: String?,

    @Column(name = "suggested_price_gp", nullable = false)
    var suggestedPriceGp: Short,

    @Column(nullable = false)
    var weight: Double
) : BaseEntity() {

    companion object : PanacheCompanion<Equipment>

}