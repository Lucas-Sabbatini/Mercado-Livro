package com.mercadoLivro.mercadoLivro.services

import com.mercadoLivro.mercadoLivro.models.CustomerModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomerServices {
    val customerList = mutableListOf<CustomerModel>()
    var currentId: Int = 0

    fun getCustomers(@RequestParam name:String?): List<CustomerModel> {
        name?.let{
            return customerList.filter{ it.name.contains(name,true)}
        }
        return customerList
    }

    fun getCustomer(@PathVariable id:String): CustomerModel{
        return customerList.first { it.id == id }
    }

    fun createCustomer(customer: CustomerModel){
        currentId++
        customerList.add(CustomerModel(currentId.toString(),customer.email,customer.name))
        println(customer)
    }

    fun updateCustomer(customer: CustomerModel){
        customerList.first {it.id == customer.id}.let{
            it.email = customer.email
            it.name = customer.name
        }
    }

    fun deleteCustomer(id:String){
        customerList.removeIf{it.id == id}
    }
}