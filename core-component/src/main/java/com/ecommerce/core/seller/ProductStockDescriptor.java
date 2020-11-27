package com.ecommerce.core.seller;

import com.ecommerce.core.common.Price;
import lombok.*;

import java.util.List;

//@Valid
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockDescriptor {
    private String id;
    private int quantity;
    private List<String> barcodeList;
    private Price price;

//    public ProductStockDescriptor() {
//    }
//
//    public ProductStockDescriptor(String id , int quantity, List<String> barcodeList, Price price) {
//        this.id = id;
//        this.quantity = quantity;
//        this.barcodeList = barcodeList;
//        this.price = price;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public Price getPrice() {
//        return price;
//    }
//
//    public void setPrice(Price price) {
//        this.price = price;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public List<String> getBarcodeList() {
//        return barcodeList;
//    }
//
//    public void setBarcodeList(List<String> barcodeList) {
//        this.barcodeList = barcodeList;
//    }
}
