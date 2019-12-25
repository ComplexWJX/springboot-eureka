package com.asiainfo.aif.sale.action;

import lombok.extern.slf4j.Slf4j;
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
    @RequestMapping("/save")
    String pay(@RequestParam("serOrderId") String serOrderId){
        log.info("start to pay.");
        return "success execute:"+serOrderId;
    }
}
