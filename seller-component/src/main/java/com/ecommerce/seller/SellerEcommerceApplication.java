package com.ecommerce.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.ecommerce"})
public class SellerEcommerceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(SellerEcommerceApplication.class, args);
        System.out.println("context created");

        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(bean -> {
            System.out.println(bean);
        });
    }

}

