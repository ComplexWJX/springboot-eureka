package com.asiainfo.aif.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {"com.asiainfo.aif.api","com.asiainfo.aif.portal"})
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class})
public class SpringEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaApplication.class, args);
    }

}
