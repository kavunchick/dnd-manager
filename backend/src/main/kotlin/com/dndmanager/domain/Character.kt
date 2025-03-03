package com.dndmanager.domain

import com.dndmanager.domain.helper.Alignment
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

    @Column(name = "personality_traits")
    var personalityTraits: String?,

    var alignment: Alignment,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "character_class", nullable = false)
    var characterClass: Class,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    var race: Race,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ability_bonus", nullable = false)
    var abilityBonus: RaceAbilityBonus
) : BaseEntity() {

    companion object : PanacheCompanion<Character>

}