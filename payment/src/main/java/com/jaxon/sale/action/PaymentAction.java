package com.jaxon.sale.action;

import com.jaxon.sale.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    String pay(@RequestParam("serOrderId") String serOrderId) {
        paymentService.save(serOrderId);
        return "success execute:" + serOrderId;
    }
}
