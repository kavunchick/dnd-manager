package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.*

@Entity
data class RaceAbilityBonus(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ability_id", nullable = false)
    var ability: Ability,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id", nullable = false)
    var race: Race,

    @Column(nullable = false)
    var bonus: Short
) : BaseEntity() {

    companion object : PanacheCompanion<RaceAbilityBonus>

}