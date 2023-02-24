package com.example.bank.controller.repository

import org.springframework.data.annotation.Id
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue

//in order to save into the database
//@Entity: indicates class will be used by jpa to save the data into the database
@Entity
class TransactionDBModel (
    val accountIdentifier:String,
    val value:Double,
    val description: String="",
    ){
    //@Id:indicate the filed will be the primary key in the database for the entity
    //@GeneratedValue: auto generate its own value
    //receive the atrributes in the api
    @Id
    @GeneratedValue
    var id: UUID?=null
    private set
    val date:Date=Date()

}