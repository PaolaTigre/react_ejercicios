package com.example.proyectdg.service

import com.example.proyectdg.model.Invoice
import com.example.proyectdg.repository.ClientRepository
import com.example.proyectdg.repository.InvoiceRepository
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class InvoiceServiceTest {

    @InjectMocks
    lateinit var invoiceService: InvoiceService

    @Mock
    lateinit var invoiceRepository: InvoiceRepository

    @Mock
    lateinit var clientRepository: ClientRepository

    val jsonString = File("./src/test/resources/invoice.json").readText(Charsets.UTF_8)
    val invoiceMock = Gson().fromJson(jsonString, Invoice::class.java)

    val jsonString = File("./src/test/resources/invoice.json").readText(Charsets.UTF_8)
    val invoiceMock = Gson().fromJson(jsonString, Invoice::class.java)


    val invoiceMock = Invoice().apply {
        id=1
        nui="0301707030"
        fullname="Juan"
        address= "Cuenca"
    }

    @Test
    fun saveInvoiceWhenIsCorrect(){
        Mockito.`when`(invoiceRepository.findById(invoiceMock.clientId)).thenReturn(invoiceMock)
        Mockito.`when`(invoiceRepository.save(Mockito.any(Invoice::class.java))).thenReturn(invoiceMock)
        val response = invoiceService.save(invoiceMock)
        Assertions.assertEquals(response.id, invoiceMock.id)
    }



}

