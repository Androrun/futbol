package com.example.futbol.model

import jakarta.persistence.*
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull


@Entity
@Table(name="Player")
class Player {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank (message = " Ingrese un nombre el campo no puede estar vacio")
    var fullname: String? = null

    @NotNull
    @Min(18)
    @Max(90)
    var age: Int? = null

    @NotBlank  (message = " Ingrese su nacionalidad  el campo no puede estar vacio")
    var nationality: String? = null
    var weight: Double? = null
    var fairplay: Double? = null

}
