package com.example.bank.controller.model

import com.example.bank.controller.repository.TransactionDBModel

class TransactionModel(
    val targetAccount:String,
    val value:Double,
    val description:String="",
    )
//从endpoint接收到的TransactionModel，转化成存储在数据库中的DBModel
//the model we receive in the endpoint is different from the one that we use in database
fun TransactionModel.convertToDBModel()=TransactionDBModel(
    accountIdentifier=this.targetAccount,
    value=this.value,
    description=this.description
)
