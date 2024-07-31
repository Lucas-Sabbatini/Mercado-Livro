package com.mercadoLivro.mercadoLivro.controlers

import com.mercadoLivro.mercadoLivro.controlers.requests.postCustomerRequest
import com.mercadoLivro.mercadoLivro.models.CustomerModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController //falando para o spring boot que a classe abaixo será um controller
@RequestMapping("customer")
class CustomerController {
    @GetMapping
    fun getCustomer(): CustomerModel{
        return CustomerModel.createDefaultCustomer()
    }

    @PostMapping
    fun createCustomer(@RequestBody customer: postCustomerRequest)/*: CustomerModel*/{
        println(customer)
    }



    //alterando e criando novos endpoints para a nossa aplicação
    // get - recuperar um dado
    // post - gravar um dado novo
    // put - alterar todos os valores que compoem um dado
    // delete - apagar um dado
    // patch - alterar parcialmete um dado
}