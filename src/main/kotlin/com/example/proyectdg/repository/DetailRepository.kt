package com.example.proyectdg.repository


import com.example.proyectdg.model.Detail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository

interface DetailRepository : JpaRepository<Detail, Long?>{

    @Query(nativeQuery =true)//Va a leer jpa-named.....
    fun sumTotal(@Param("invoiceId") invoiceId: Long?): Double?
    fun findById(id:Long?):Detail?


}


