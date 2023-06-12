package com.example.futbol.controller

import com.example.Futbol.service.AdvisesService
import com.example.futbol.model.Advises
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping ("/advises")

class AdvisesController {
    @Autowired
    lateinit var advisesService: AdvisesService

    @GetMapping
    fun list(): ResponseEntity<*> {
        return ResponseEntity(advisesService.list(), HttpStatus.OK)
    }

    @PostMapping

   /* fun save (@RequestBody advises: Advises): ResponseEntity<Advises> {
        return ResponseEntity(advisesService.save(advises), HttpStatus.OK)
    }*/

    fun save (@RequestBody advises: Advises): ResponseEntity<Advises> {
        return ResponseEntity(advisesService.save(advises), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody advises: Advises): ResponseEntity<Advises> {
        return ResponseEntity(advisesService.update(advises), HttpStatus.OK)
    }

    @PatchMapping
    fun updateColorCard (@RequestBody advises: Advises): ResponseEntity<Advises> {
        return ResponseEntity(advisesService.updateColorCard(advises), HttpStatus.OK)
    }


}