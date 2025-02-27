package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.*

@Entity
data class SessionsCharacter (

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    var session: Session,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", nullable = false)
    var character: Character,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", nullable = false)
    var inventory: CharacterInventory,

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
) : PanacheEntity()  {

    companion object : PanacheCompanion<SessionsCharacter>

}