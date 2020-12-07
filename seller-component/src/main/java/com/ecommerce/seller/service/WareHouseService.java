package com.ecommerce.seller.service;

import com.ecommerce.core.inventory.Stock;
import com.ecommerce.core.seller.ProductStockDescriptor;
import com.ecommerce.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WareHouseService {

    @Autowired
    private InventoryService inventoryService;

    public String fillStock(String productId, ProductStockDescriptor productStockDescriptor, String sellerId) {
        List<Stock> stocks = convertToStockList(productId, sellerId, productStockDescriptor);
        stocks.stream().forEach(stock ->
                inventoryService.fillUp(stock));
        return productStockDescriptor.getId();
    }

    private List<Stock> convertToStockList(String productId, String sellerId, ProductStockDescriptor productStockDescriptor) {
        List<Stock> stockList = new ArrayList<>();
        for (String uniqueBarcode : productStockDescriptor.getBarcodeList()) {
            Stock stock = new Stock(productId, sellerId, uniqueBarcode, productStockDescriptor);
            stockList.add(stock);
        }
        return stockList;
    }
}
