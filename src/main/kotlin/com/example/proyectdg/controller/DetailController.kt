package com.example.proyectdg.controller

import com.example.proyectdg.model.Detail
import com.example.proyectdg.service.DetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/detail")

class DetailController {
    @Autowired
    lateinit var detailService: DetailService

    @PostMapping
    fun save (@RequestBody @Valid detail:Detail):Detail{
        return detailService.save(detail)
    }

    @GetMapping
    fun list ():List<Detail>{
        return detailService.list()
    }

    @PutMapping
    fun update (@RequestBody @Valid detail:Detail):ResponseEntity<Detail>{
        return ResponseEntity(detailService.update(detail), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody @Valid detail:Detail): ResponseEntity<Detail>{
        return ResponseEntity(detailService.updateName(detail), HttpStatus.OK)
    }
}