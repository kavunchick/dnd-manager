package com.dndmanager.domain

import com.dndmanager.domain.helper.Size
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.*

@Entity
@Table(name = "races")
data class Race (

    @Column(nullable = false)
    var name: String,

    var description: String?,

    @Column(nullable = false)
    var size: Size,

    @Column(nullable = false)
    var speed: Short,
) : BaseEntity() {

    companion object : PanacheCompanion<Race>

}