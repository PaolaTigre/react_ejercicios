package com.example.proyectdg.controller

import com.example.proyectdg.model.Product
import com.example.proyectdg.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/product")

class ProductController {
    @Autowired
    lateinit var productService: ProductService

    @PostMapping
    fun save (@RequestBody @Valid product:Product):Product{
        return productService.save(product)
    }

    @GetMapping
    fun list ():List<Product>{
        return productService.list()
    }

    @PutMapping
    fun update (@RequestBody @Valid product:Product):ResponseEntity<Product>{
        return ResponseEntity(productService.update(product), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody @Valid product:Product): ResponseEntity<Product>{
        return ResponseEntity(productService.updateName(product), HttpStatus.OK)
    }
}