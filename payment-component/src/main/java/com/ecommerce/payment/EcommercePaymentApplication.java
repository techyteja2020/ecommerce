package com.ecommerce.payment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.ecommerce"})
public class EcommercePaymentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(EcommercePaymentApplication.class, args);
        System.out.println("payment context created");

        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(bean -> {
            System.out.println(bean);
        });
    }

}



