package com.jaxon.sale.service.impl;

import com.jaxon.sale.dao.PaymentDao;
import com.jaxon.sale.entity.Order;
import com.jaxon.sale.service.IPaymentService;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Koala
 * @description
 * @date 2019/12/27 0027
 */
@Slf4j
@Transactional
@Service
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private PaymentDao paymentDao;


    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    @Override
    public void save(String serOrderId) {
        log.info("start to pay.");
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setUserId(1);
        order.setOrderNo(serOrderId);
        paymentDao.save(order);
    }

}
