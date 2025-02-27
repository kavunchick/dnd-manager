package com.dndmanager.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.*

@Entity
data class Money (

    @Column(nullable = false)
    var currency: String,

    @Column(nullable = false)
    var exchangeRateCp: Double,

    @Column(nullable = false)
    var exchangeRateSp: Double,

    @Column(nullable = false)
    var exchangeRateEp: Double,

    @Column(nullable = false)
    var exchangeRateGp: Double,

    @Column(nullable = false)
    var exchangeRatePp: Double,
) : PanacheEntity() {

    companion object : PanacheCompanion<Money>

}