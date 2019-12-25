package com.asiainfo.aif.sale.action;

import com.asiainfo.aif.sale.rest.PaymentRest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Koala
 * @description
 * @date 2019/12/22 0022
 */
@Slf4j
@RequestMapping(path = "/sale")
@RestController
public class SaleAccess {
    @Autowired
    private PaymentRest paymentRest;
    @RequestMapping(value = "/build",method = {RequestMethod.GET,RequestMethod.POST})
    String buildOrder(@RequestParam("serOrderId") String serOrderId) {
        String result;
        try {
            result = paymentRest.pay(UUID.randomUUID().toString() + ":" + serOrderId);
            log.info(result);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("call failed",e);
            result = "build order failed.";
        }
        return result;
    }
}
