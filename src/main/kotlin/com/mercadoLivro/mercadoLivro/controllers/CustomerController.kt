package com.mercadoLivro.mercadoLivro.controllers


import com.mercadoLivro.mercadoLivro.controllers.requests.PostCustomerRequest
import com.mercadoLivro.mercadoLivro.extensions.toCustomerModel
import com.mercadoLivro.mercadoLivro.models.CustomerModel
import com.mercadoLivro.mercadoLivro.services.CustomerServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController //falando para o spring boot que a classe abaixo será um controller
@RequestMapping("customers")
class CustomerController (
        val customerServices: CustomerServices
){

    @GetMapping
    fun getCustomers(@RequestParam name:String?): List<CustomerModel> {
        return customerServices.getCustomers(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id:String): CustomerModel{
        return  customerServices.getCustomer(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest)/*: CustomerModel*/{
        customerServices.createCustomer(customer.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id:String,@RequestBody customer: PostCustomerRequest){
        customerServices.updateCustomer(customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id:String){
        customerServices.deleteCustomer(id)
    }
    //alterando e criando novos endpoints para a nossa aplicação
    // get - recuperar um dado
    // post - gravar um dado novo
    // put - alterar todos os valores que compoem um dado
    // delete - apagar um dado
    // patch - alterar parcialmete um dado
}