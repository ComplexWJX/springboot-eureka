package com.jaxon.payment;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.jaxon.aif"})
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.jaxon.aif"})
@MapperScan(basePackages = {"com.jaxon.aif.sale.dao"})
@EnableDistributedTransaction
@EnableTransactionManagement
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

}
