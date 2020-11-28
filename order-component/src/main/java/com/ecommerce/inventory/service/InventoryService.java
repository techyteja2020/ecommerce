package com.ecommerce.inventory.service;

import com.ecommerce.core.inventory.Stock;
import com.ecommerce.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public String fillUp(Stock stock){
        Stock savedStock = inventoryRepository.save(stock.getBarcode() ,stock);
        return savedStock.getBarcode();
    }
}
