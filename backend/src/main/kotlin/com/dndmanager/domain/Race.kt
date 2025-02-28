package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.*

@Entity
@Table(name = "races")
data class Race (

    @Column(nullable = false)
    var name: String,

    var description: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    var type: CreatureType,

    @Column(nullable = false)
    var size: Short,
) : BaseEntity() {

    companion object : PanacheCompanion<Race>

}