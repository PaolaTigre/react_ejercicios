package com.example.proyectdg.model

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name="product")

class Product  {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank
    @NotNull
    var description: String? = null
    @NotBlank
    @NotNull
    var brand: String?=null
    var stock: Long?=null
    var price:Double?=null
}