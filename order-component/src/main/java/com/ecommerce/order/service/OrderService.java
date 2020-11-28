package com.ecommerce.order.service;

import com.ecommerce.core.order.CustomerOrder;
import com.ecommerce.model.OrderRecord;
import com.ecommerce.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public String createOrder(CustomerOrder customerOrder, String customerId) {
        OrderRecord orderRecord = createOrderRecord(customerId,customerOrder);
        OrderRecord savedOrderRecord = orderRepository.save(orderRecord);
        return savedOrderRecord.getId();
    }

    private OrderRecord createOrderRecord(String customerId, CustomerOrder customerOrder) {
        OrderRecord orderRecord = OrderRecord.builder()
                .id(customerOrder.getId())
                .customerId(customerId)
                .cartId(customerOrder.getCartId())
                .billToAddressId(customerOrder.getBillToAddressId())
                .shipToAddressId(customerOrder.getShipToAddressId())
                .paymentRecordId(customerOrder.getPaymentRecordId())
                .paymentTxnid(customerOrder.getPaymentTxnid())
                .build();
    return orderRecord;
    }
}
