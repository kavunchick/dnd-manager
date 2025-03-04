package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.*

@Entity
@Table(name = "session_character")
data class SessionsCharacter (

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    var session: Session,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", nullable = false)
    var character: Character,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", nullable = false)
    var inventory: List<CharacterInventory>,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "money_id", nullable = false)
    var money: Money,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "abilities_id", nullable = false)
    var abilities: CharacterAbility,

    @Column(nullable = false)
    var level: Short,

    @Column( nullable = false)
    var experience: Short,

    @Column(nullable = false)
    var health: Short,
) : BaseEntity()  {

    companion object : PanacheCompanion<SessionsCharacter>

}