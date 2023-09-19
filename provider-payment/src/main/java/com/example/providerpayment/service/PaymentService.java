package com.example.providerpayment.service;

import com.example.apicommon.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);
    Payment queryById(@Param("id") long id);
}
