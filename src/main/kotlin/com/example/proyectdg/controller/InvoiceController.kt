package com.example.proyectdg.controller

import com.example.proyectdg.model.Invoice
import com.example.proyectdg.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/invoice")

class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService

    @PostMapping
    fun save (@RequestBody @Valid invoice:Invoice):Invoice{
        return invoiceService.save(invoice)
    }

    @GetMapping
    fun list ():List<Invoice>{
        return invoiceService.list()
    }

    @PutMapping
    fun update (@RequestBody @Valid invoice:Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.update(invoice), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody @Valid invoice:Invoice): ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.updateName(invoice), HttpStatus.OK)
    }
}