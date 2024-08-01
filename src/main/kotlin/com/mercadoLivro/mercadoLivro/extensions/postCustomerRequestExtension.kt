package com.mercadoLivro.mercadoLivro.extensions

import com.mercadoLivro.mercadoLivro.controllers.requests.PostCustomerRequest
import com.mercadoLivro.mercadoLivro.models.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel{
    return CustomerModel(name= this.name,email = this.email)
}

fun PostCustomerRequest.toCustomerModel(id:String): CustomerModel{
    return CustomerModel(id,email,name)
}