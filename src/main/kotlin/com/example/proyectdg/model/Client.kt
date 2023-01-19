package com.example.proyectdg.model

import javax.persistence.*

@Entity
@Table(name="client")

class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var fullname: String? = null
    var nui: String?=null
    var address: String?=null
}