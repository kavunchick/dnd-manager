package com.dndmanager.domain

import com.dndmanager.domain.helper.Alignment
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.*

@Entity
data class Npc (

    @Column(nullable = false)
    var name: String,

    @Column(columnDefinition = "TEXT", nullable = false)
    var description: String,

    @Column(nullable = false)
    var health: Short,

    var alignment: Alignment,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    var classField: Class,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    var race: Race,

    @Column(nullable = false)
    var isHostile: Boolean,

    @Column(nullable = false)
    var role: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    var location: Location? = null
) : BaseEntity() {

    companion object : PanacheCompanion<Npc>

}