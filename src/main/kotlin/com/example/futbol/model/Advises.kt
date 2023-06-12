package com.example.Futbol.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity //representacion de una clase es un mapeo
@Table(name="Advises") //enlazar la tabla clientes en la base de datos

class Advises {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id: Long? =null

    @Column(name="date_match")
    var dateMath: Date? =null


    var matches: Int? =null

    @Column(name="color_card")
    var colorCard: String? =null

    @Column(name="player_id")
    var playerId: Long? = null



}