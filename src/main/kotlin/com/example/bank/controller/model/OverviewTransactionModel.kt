package com.example.bank.controller.model

import com.example.bank.controller.repository.TransactionDBModel
import java.util.*

class OverviewTransactionModel (
    val targetAccount:String,
    val value:Double,
    val description:String="",
    val date: Date,
    val id:String
)
//存储在数据库中的DBModel,转化成要发给endpoint的OverviewTransactionModel
//这里的this指的是TransactionDBModel
fun TransactionDBModel.converToOverviewModel()=OverviewTransactionModel(
    targetAccount = this.accountIdentifier,
    value=this.value,
    description=this.description,
    date=this.date,
    id=this.id.toString(),
)