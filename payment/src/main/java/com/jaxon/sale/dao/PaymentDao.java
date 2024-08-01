package com.jaxon.sale.dao;

import com.jaxon.sale.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    void save(Order order);
}
