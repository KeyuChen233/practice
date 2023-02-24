package com.example.bank.controller

import com.example.bank.controller.model.OverviewTransactionModel
import com.example.bank.controller.model.TransactionModel
import com.example.bank.controller.model.converToOverviewModel
import com.example.bank.controller.model.convertToDBModel
import com.example.bank.controller.repository.TransferRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//@RestController是@ResponseBody和@Controller的组合注解.
// indicate the spring boot this class is a web controller
// it will receive requests and return response
//@ResponseBody的作用其实是将java对象转为json格式的数据
@RestController
//处理请求地址映射
@RequestMapping("/transfer")
class TransferController(val repository: TransferRepository) {
    @PostMapping("/new")
    //注解@RequestBody用于接收前端传递给后端的、JSON对象的字符串
    //part of this request + deserialize the JSON automatically into our model
    fun newTransfer(@RequestBody transactionModel: TransactionModel){
        //TODO:Save the data
        repository.save(transactionModel.convertToDBModel())
        System.out.println("Saved")
    }
    //localhost:8080/transfer/all
    @GetMapping("/all")
    fun getAllTransfers():List<OverviewTransactionModel>{
        //TODO:Fetch the data
        return repository.findAll().map{it.converToOverviewModel()}
    }
}