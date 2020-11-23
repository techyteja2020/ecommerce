package com.ecommerce.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.ecommerce"})
public class CustomerEcommerceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(CustomerEcommerceApplication.class, args);
        System.out.println("customer context created");

        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(bean -> {
            System.out.println(bean);
        });
    }

}


