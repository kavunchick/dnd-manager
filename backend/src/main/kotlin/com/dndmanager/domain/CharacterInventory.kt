package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity
import jakarta.persistence.Column
import jakarta.persistence.ManyToOne
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn

@Entity
data class CharacterInventory(

    @Column(nullable = false)
    var amount: Int,

    @Column(nullable = false)
    var characterId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    var equipment: Equipment
) : PanacheEntity() {

    companion object : PanacheCompanion<CharacterInventory>

}