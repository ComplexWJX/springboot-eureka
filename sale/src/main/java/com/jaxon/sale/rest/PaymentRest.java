package com.jaxon.sale.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "paas-payment")
public interface PaymentRest {
    @RequestMapping("/pay/save")
    String pay(@RequestParam("serOrderId") String serOrderId);
}
