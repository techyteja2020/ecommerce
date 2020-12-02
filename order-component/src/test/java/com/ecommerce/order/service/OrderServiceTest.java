package com.ecommerce.order.service;

import com.ecommerce.core.order.CustomerOrder;
import com.ecommerce.model.OrderRecord;
import com.ecommerce.order.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void shouldCreateOrderAndReturnOrderId(){
        String orderId = "order001";
        CustomerOrder customerOrder = CustomerOrder.builder()
                .billToAddressId("bill To address")
                .cartId("cart001")
                .id(orderId)
                .paymentRecordId("payRec001")
                .paymentTxnid("payTx001")
                .shipToAddressId("Ship to address")
                .build();
        OrderRecord orderRecord = mock(OrderRecord.class);

        when(orderRepository.save(any(OrderRecord.class))).thenReturn(orderRecord);
        when(orderRecord.getId()).thenReturn(orderId);

        String actualOrderId = orderService.createOrder(customerOrder,"customer001");

        assertEquals(orderId, actualOrderId);
    }
}
