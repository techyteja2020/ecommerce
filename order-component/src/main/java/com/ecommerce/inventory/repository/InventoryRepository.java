package com.ecommerce.inventory.repository;

import com.ecommerce.core.CustomRepository;
import com.ecommerce.core.inventory.Stock;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InventoryRepository  extends CustomRepository<Stock> {
    private static Map<String,List<Stock>> inventoryRepo = new HashMap();

    public Stock save(String barcode, Stock stock) {
        return super.save(barcode, stock);
    }
}
