package com.ecommerce.core.inventory;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.seller.ProductStockDescriptor;

import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return productId.equals(stock.productId) &&
                sellerId.equals(stock.sellerId) &&
                barcode.equals(stock.barcode) &&
                price.equals(stock.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, sellerId, barcode, price);
    }
}
