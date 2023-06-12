package com.example.futbol.service

import com.example.futbol.model.Player
import com.example.futbol.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PlayerService {
    @Autowired
    lateinit var playerRepository: PlayerRepository
    fun list ():List<Player>{
        return playerRepository.findAll() //llama al metodo del metodo del repositorio y llama a cada uno de los metodos
    }
    fun save (player: Player):Player{
        return playerRepository.save(player)
    }
    fun update (player: Player): Player{
        try {
            playerRepository.findById(player.id)
                    ?: throw Exception("id no existe")
            return playerRepository.save(player)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(player: Player): Player {
        try{
            val response = playerRepository.findById(player.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                fullname=player.fullname
            }
            return playerRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateFairplay (playerId: Long?, fairplayUpdated:Double): Player {
        try{
            val response= playerRepository.findById(playerId)
                    ?: throw Exception("ID no existe")
            response.apply {
                fairplay= fairplayUpdated  }
            return playerRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun findAvailablePlayer(): List<Player>? {
        return playerRepository.findAvailablePlayer()
    }

    fun findTotalPlayer(age:Int?): List<Player>? {
        return playerRepository.findTotalPlayer(age)
    }



}