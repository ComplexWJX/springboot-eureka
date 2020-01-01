package com.asiainfo.aif.sale.action;

import com.asiainfo.aif.sale.dao.PaymentDao;
import com.asiainfo.aif.sale.entity.Order;
import com.asiainfo.aif.sale.service.IPaymentService;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Koala
 * @description
 * @date 2019/12/22 0022
 */
@RestController
@RequestMapping("/pay")
@Slf4j
public class PaymentAction {

    @Autowired
    private IPaymentService paymentService;

    @RequestMapping("/save")
    String pay(@RequestParam("serOrderId") String serOrderId){
        paymentService.save(serOrderId);
        return "success execute:"+serOrderId;
    }
}
