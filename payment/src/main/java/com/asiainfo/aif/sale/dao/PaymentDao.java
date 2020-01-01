package com.asiainfo.aif.sale.dao;

import com.asiainfo.aif.sale.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    void save(Order order);
}
