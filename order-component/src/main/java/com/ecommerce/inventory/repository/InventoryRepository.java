package com.ecommerce.inventory.repository;

import com.ecommerce.core.CustomRepository;
import com.ecommerce.core.inventory.Stock;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InventoryRepository  extends CustomRepository {
    private static Map<String,List<Stock>> inventoryRepo = new HashMap();

    public void save(String barcodeList, Stock stock) {
        super.save(barcodeList, stock);
    }
}
