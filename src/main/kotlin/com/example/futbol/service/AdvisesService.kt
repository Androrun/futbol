package com.example.Futbol.service


import com.example.Futbol.model.Advises
import com.example.futbol.repository.AdvisesRepository
import com.example.futbol.repository.PlayerRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class AdvisesService {
    @Autowired //
    lateinit var advisesRepository: AdvisesRepository

    @Autowired
    lateinit var playerRepository: PlayerRepository

    fun list ():List<Advises>{
        return advisesRepository.findAll() //llama al metodo del metodo del repositorio y llama a cada uno de los metodos
    }
    /*fun save (advises: Advises): Advises {
        try {
            playerRepository.findById(advises.playerId)
                    ?: throw Exception ("Id de player no exist")
            return advisesRepository.save(advises)
        } catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message,ex)
        }
    }*/

    fun save (advises: Advises): Advises {
        try {
            val responsePlayer=playerRepository.findById(advises.playerId)
                    ?: throw Exception ("Id de player no exist")
            val responseAdvises=advisesRepository.save(advises)
            //Pasos adicionales obtener el total de las amonestaciones
            val totalAdvises=getTotalAdvises(advises.playerId)
            playerRepository.save(responsePlayer.apply { fairplay=totalAdvises })

            return responseAdvises
        } catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message,ex)
        }
    }
    fun getTotalAdvises(playerId: Long? ): Double? {
        return advisesRepository.getTotalAdvises(playerId)
    }

    fun update (advises: Advises): Advises {
        try {
            advisesRepository.findById(advises.id)
                    ?: throw Exception("id no existe")
            return advisesRepository.save(advises)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateColorCard(advises: Advises): Advises {
        try{
            val response = advisesRepository.findById(advises.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                colorCard=advises.colorCard
            }
            return advisesRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}