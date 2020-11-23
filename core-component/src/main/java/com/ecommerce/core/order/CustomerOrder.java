package com.ecommerce.core.order;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrder {
    private String id;
    private String paymentTxnid;
    private String cartId;
    private String billToAddressId;
    private String shipToAddressId;
    private String paymentRecordId;

}
