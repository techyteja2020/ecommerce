package com.ecommerce.inventory.service;

import com.ecommerce.core.inventory.Stock;
import com.ecommerce.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public void fillUp(Stock stock){
        inventoryRepository.save(stock.getBarcode() ,stock);
    }
}
