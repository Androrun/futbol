package com.example.futbol.repository

import com.example.futbol.model.Advises
import com.example.futbol.model.Player
import jakarta.persistence.NamedNativeQuery
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.lang.annotation.Native

@Repository
interface AdvisesRepository:JpaRepository<Advises, Long> {

    fun findById(id: Long?):Advises?

    @Query(nativeQuery =true)//Va a leer jpa-named.....
    fun getTotalAdvises(@Param("playerId") playerId: Long?): Double?


}