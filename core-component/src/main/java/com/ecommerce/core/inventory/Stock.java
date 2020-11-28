package com.ecommerce.core.inventory;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.seller.ProductStockDescriptor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class Stock {
    private String productId;
    private String sellerId;
    private String barcode;
    private String stockFillingId;
    private Price price;

    public Stock(String productId, String sellerId, String uniqueBarcode, ProductStockDescriptor productStockDescriptor) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.barcode = uniqueBarcode;
        this.price = productStockDescriptor.getPrice();
        this.stockFillingId = productStockDescriptor.getId();
    }
}
