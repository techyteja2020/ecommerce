package com.ecommerce.core.inventory;

import com.ecommerce.core.common.Price;

import java.util.Objects;

public class Stock {
    private String productId;
    private String sellerId;
    private String barcode;
    private String stockFillingId;
    private Price price;

    public String getBarcode() {
        return barcode;
    }

    public Stock(String productId, String sellerId, String barcode, Price price, String id) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.barcode = barcode;
        this.price = price;
        this.stockFillingId = id;
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
