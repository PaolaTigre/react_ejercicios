package com.example.proyectdg.service


import com.example.proyectdg.model.Client
import com.example.proyectdg.model.Product
import com.example.proyectdg.repository.ClientRepository
import com.example.proyectdg.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import kotlin.math.exp

@Service

class ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository


    fun save (product: Product):Product{
            try {
               product.description?.takeIf { it.trim().isNotEmpty() }
                    ?:throw Exception("description no debe ser vacio")
                product.stock?.takeIf { product.stock!!<0 }
                    ?:throw Exception("description no debe ser vacio")
                return productRepository.save(product)
            }
            catch (ex:Exception){
                throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
            }




    }
    fun list ():List<Product>{
        return productRepository.findAll()
    }


    fun update(client:Product):Product{
        try{
            productRepository.findById(client.id)
                    ?: throw Exception ("El Id no existe")
            return productRepository.save(client)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(product:Product): Product {
        try{
            val response = productRepository.findById(product.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                description=product.description
            }
            return productRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}