package com.ecommerce.seller.service;

import com.ecommerce.core.inventory.Stock;
import com.ecommerce.core.seller.ProductStockDescriptor;
import com.ecommerce.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WareHouseService {

    @Autowired
    private InventoryService inventoryService;

    public String fillStock(String productId, ProductStockDescriptor productStockDescriptor, String sellerId) {
        List<Stock> stocks = productStockDescriptor.convertToStockList(productId, sellerId);
        stocks.stream().forEach(stock -> inventoryService.fillUp(stock));
        return productStockDescriptor.getId();
    }
}
