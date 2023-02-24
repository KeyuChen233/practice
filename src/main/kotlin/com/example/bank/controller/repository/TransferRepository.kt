package com.example.bank.controller.repository

import org.springframework.data.repository.CrudRepository
import java.util.UUID

//extend our transfer repository with crud repository
//Spring will find what we are using and will inject the full imp
//JpaRepository是SpringBoot Data JPA提供的非常强大的基础接口。
interface TransferRepository: CrudRepository<TransactionDBModel,UUID> {
}