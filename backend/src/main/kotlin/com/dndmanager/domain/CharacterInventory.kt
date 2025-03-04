package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.*

@Entity
@Table(name = "character_inventory")
data class CharacterInventory(

    @Column(nullable = false)
    var amount: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    var character: SessionsCharacter,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    var equipment: Equipment
) : BaseEntity() {

    companion object : PanacheCompanion<CharacterInventory>

}