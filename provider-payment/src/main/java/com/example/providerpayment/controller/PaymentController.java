package com.example.providerpayment.controller;


import com.example.apicommon.pojo.CommonResult;
import com.example.apicommon.pojo.Payment;
import com.example.providerpayment.service.PaymentServiceImpl;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.providerpayment.service.PaymentService;

@Controller
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource(name = "paymentServiceImpl")
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult<Integer> create(@RequestBody Payment dept){
        int i=paymentService.create(dept);
        log.info("insert payment successfully, index : "+i);

        if (i>0){
            return new CommonResult<>(200, "Successfully create payment " + serverPort, i);
        }else {
            return new CommonResult<>(444, "Fail to create payment", null);
        }
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public CommonResult<Payment> queryById(@PathVariable("id") long id){
        Payment payment = paymentService.queryById(id);
        log.info("Query success, payment: "+payment);

        if (payment!=null){
            return new CommonResult<>(200, "Query successfully " + serverPort, payment);
        }else {
            return new CommonResult<>(444, "Fail to query payment ", null);
        }
    }
}
