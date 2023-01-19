package com.example.proyectdg.service


import com.example.proyectdg.model.Detail
import com.example.proyectdg.model.Product
import com.example.proyectdg.repository.InvoiceRepository
import com.example.proyectdg.repository.DetailRepository
import com.example.proyectdg.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class DetailService {
    @Autowired
    lateinit var detailRepository: DetailRepository

    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    @Autowired
    lateinit var productRepository: ProductRepository

    fun save(details: Detail): Detail {
        try{
            val response=detailRepository.save(details)
            val responseProduct: Product = productRepository.findById(response.productId)
            responseProduct.apply {
                stock = stock?.minus(details.quantity!!)
            }
            productRepository.save(responseProduct)
            calculateAndUpdateTotal(response)
            return response
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun list ():List<Detail>{
        return detailRepository.findAll()
    }


    fun update(client:Detail):Detail{
        try{
            detailRepository.findById(client.id)
                    ?: throw Exception ("El Id no existe")
            return detailRepository.save(client)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(detail:Detail): Detail {
        try{
            val response = detailRepository.findById(detail.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                quantity=detail.quantity
            }
            return detailRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun calculateAndUpdateTotal (detail : Detail){
        val totalCalculated = detailRepository.sumTotal(detail.invoiceId)
        val invoiceResponse = invoiceRepository.findById(detail.invoiceId)
        invoiceResponse.apply {
            total=totalCalculated
        }
        invoiceRepository.save(invoiceResponse)
    }

}