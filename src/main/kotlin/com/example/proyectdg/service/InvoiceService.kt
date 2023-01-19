package com.example.proyectdg.service


import com.example.proyectdg.model.Invoice
import com.example.proyectdg.repository.ClientRepository
import com.example.proyectdg.repository.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class InvoiceService {
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    @Autowired
    lateinit var clientRepository: ClientRepository

    fun save (invoice: Invoice):Invoice{
        try {
            clientRepository.findById(invoice.clientId)
                    ?: throw Exception("Cliente no existe")
            return invoiceRepository.save(invoice)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun list ():List<Invoice>{
        return invoiceRepository.findAll()
    }


    fun update(client:Invoice):Invoice{
        try{
            invoiceRepository.findById(client.id)
                    ?: throw Exception ("El Id no existe")
            return invoiceRepository.save(client)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(invoice:Invoice): Invoice {
        try{
            val response = invoiceRepository.findById(invoice.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                code=invoice.code
            }
            return invoiceRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}