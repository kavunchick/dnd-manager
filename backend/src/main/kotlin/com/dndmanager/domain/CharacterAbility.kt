package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Column
import jakarta.persistence.ManyToOne
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn

@Entity
@Table(name = "character_abilities")
data class CharacterAbility(

    @Column(nullable = false)
    var value: Short,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    var ability: Ability,

    @Column(nullable = false)
    var sessionCharacterId: Long,
) : PanacheEntity()