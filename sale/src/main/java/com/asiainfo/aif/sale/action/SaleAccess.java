package com.asiainfo.aif.sale.action;

import com.asiainfo.aif.sale.service.ISaleService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Koala
 * @description 集成feign、熔断机制Hystrix
 * @date 2019/12/22 0022
 */
@Slf4j
@RequestMapping(path = "/sale")
@RestController
public class SaleAccess {

    @Autowired
    private ISaleService saleService;

    @RequestMapping(value = "/build", method = {RequestMethod.GET, RequestMethod.POST})
    @HystrixCommand(fallbackMethod = "fallback")
    public String buildOrder(@RequestParam("serOrderId") String serOrderId) {
        String result;
        try {
            result = saleService.save(serOrderId);
            log.info(result);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("call failed", e);
//            result = "build order failed.";
            throw e;
        }
        return result;
    }

    public String fallback(@RequestParam("serOrderId") String serOrderId) {
        String result = "could not server for[" + serOrderId + "].";
        return result;
    }
}
