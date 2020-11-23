package com.ecommerce.customer.controller;

import com.ecommerce.core.order.CustomerOrder;
import com.ecommerce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("/customers/{customerId}/order")
    public ResponseEntity placeOrder(@RequestBody CustomerOrder customerOrder,
                                          @PathVariable("customerId") String customerId) {
        String orderId = orderService.createOrder(customerOrder, customerId);
        return new ResponseEntity(orderId, HttpStatus.OK);
    }
}
