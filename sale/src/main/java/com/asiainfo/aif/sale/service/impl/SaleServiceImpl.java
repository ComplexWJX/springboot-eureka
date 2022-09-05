package com.asiainfo.aif.sale.service.impl;

import com.asiainfo.aif.sale.rest.PaymentRest;
import com.asiainfo.aif.sale.service.ISaleService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author Koala
 * @description
 * @date 2019/12/27 0027
 */
@Service
public class SaleServiceImpl implements ISaleService {

    @Autowired
    private PaymentRest paymentRest;


    @LcnTransaction
    @Transactional
    @Override
    public String save(String orderNo) {
        String result = paymentRest.pay(UUID.randomUUID().toString() + ":" + orderNo);
        int i = 100 / Integer.parseInt(orderNo);
        return result;
    }
}
