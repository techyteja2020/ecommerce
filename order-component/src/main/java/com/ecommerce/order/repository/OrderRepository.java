package com.ecommerce.order.repository;

import com.ecommerce.core.CustomRepository;
import com.ecommerce.core.product.Product;
import com.ecommerce.model.OrderRecord;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository extends CustomRepository<OrderRecord> {

    public OrderRecord save(OrderRecord orderRecord) {
        return super.save(orderRecord.getId(), orderRecord);
    }

    public OrderRecord getById(String orderId) {
        return super.findOne(orderId);
    }
}
