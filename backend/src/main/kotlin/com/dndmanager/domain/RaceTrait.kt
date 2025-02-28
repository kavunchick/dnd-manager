package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.*

@Entity
@Table(name = "race_traits")
data class RaceTrait(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trait_id", nullable = false)
    var trait: Trait,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id", nullable = false)
    var race: Race
) : BaseEntity() {

    companion object : PanacheCompanion<RaceTrait>

}

