package com.mercadoLivro.mercadoLivro.models

data class CustomerModel(
        var id:String,
        var email:String,
        var name:String
){
    companion object{
        fun createDefaultCustomer():CustomerModel = CustomerModel("1","lucassabbatinijp@gmail.com","Lucas Janot")
    }
}