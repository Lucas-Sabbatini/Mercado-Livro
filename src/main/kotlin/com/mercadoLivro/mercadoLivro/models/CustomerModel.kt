package com.mercadoLivro.mercadoLivro.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "customer")
data class CustomerModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:String? = null,
        @Column
        var email:String,
        @Column
        var name:String
){
    constructor() : this(null, "", "")
    companion object{
        fun createDefaultCustomer():CustomerModel = CustomerModel("1","lucassabbatinijp@gmail.com","Lucas Janot")
    }
}