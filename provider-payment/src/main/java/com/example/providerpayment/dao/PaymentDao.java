package com.example.providerpayment.dao;


import com.example.apicommon.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentDao {
    int create(Payment payment);
    Payment queryById(long id);
}
