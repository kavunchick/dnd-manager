package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.*

@Entity
@Table(name = "characters")
data class Character(

    @Column(nullable = false)
    var name: String,

    var background: String?,

    var ideals: String?,

    var bonds: String?,

    var flaws: String?,

    var personalityTraits: String?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    var alignment: Alignment,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    var classField: Class,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    var race: Race,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    var abilityBonus: RaceAbilityBonus
) : BaseEntity() {

    companion object : PanacheCompanion<Character>

}