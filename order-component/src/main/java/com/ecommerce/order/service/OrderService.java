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
        orderRepository.save(orderRecord);
        return orderRecord.getId();
    }

    private OrderRecord createOrderRecord(String customerId, CustomerOrder customerOrder) {
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setId(customerOrder.getId());
        orderRecord.setCustomerId(customerId);
        orderRecord.setCartId(customerOrder.getCartId());
        orderRecord.setPaymentTxnid(customerOrder.getPaymentTxnid());
        orderRecord.setPaymentRecordId(customerOrder.getPaymentRecordId());
        orderRecord.setShipToAddressId(customerOrder.getShipToAddressId());
        orderRecord.setBillToAddressId(customerOrder.getBillToAddressId());
        return orderRecord;
    }
}
